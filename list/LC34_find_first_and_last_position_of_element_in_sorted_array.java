/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC34_find_first_and_last_position_of_element_in_sorted_array
 * Date Created : 2024-01-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-19       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-19
 **/
public class LC34_find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums,target),right_bound(nums,target)};
    }
    public int left_bound(int[] nums, int target){
        int left =0,right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                right = mid-1;
            }
        }
        if(left>=nums.length||nums[left]!=target){
            return -1;
        }
        return left;
    }
    public int right_bound(int[] nums, int target){
        int left =0,right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){
                left = mid+1;
            }
        }
        if(right<0||nums[right]!=target){
            return -1;
        }
        return right;
    }
    //第二次做，竟然短时间独立做出来了，只简单调试了几次。思路也是和labuladong一致，只不过我感觉我的更高效，因为我利用了找左边界时的信息，记下了一个更小的区间来找右边界。labuladong则是单纯找左再找右
    class Solution20240329 {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1,-1};
            if(nums==null||nums.length==0){
                return result;
            }
            int left =0,right=nums.length-1;
            int mid=0;
            int left2=0,right2=0;
            boolean hasFounded = false;
            //先找左边界
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]>target){
                    right=mid-1;
                }else if(nums[mid]==target){
                    if(!hasFounded){
                        hasFounded=true;
                        //如果是第一次找到，说明所有的target都在当前这个区间中，把这个区间记下来一会儿只在这个区间中找右边界！
                        left2=left;
                        right2=right;
                    }
                    right = mid-1;
                }else{
                    left=mid+1;
                }
            }
            if(hasFounded){
                //找左边界时，最后left作为结果index
                result[0]=left;
            }

            //开始找右边界
            hasFounded=false;
            while(left2<=right2){
                mid = left2+(right2-left2)/2;
                if(nums[mid]>target){
                    right2=mid-1;
                }else if(nums[mid]==target){
                    if(!hasFounded){
                        hasFounded=true;
                    }
                    left2 = mid+1;
                }else{
                    left2=mid+1;
                }
            }
            if(hasFounded){
                //找右边界时，最后right作为结果index（经验之谈）
                result[1]=right2;
            }

            return result;
        }


    }
}