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
    public static void main(String[] args) {
        System.out.println("testing");
        Solution20240611Wrong solution20240611 = new Solution20240611Wrong();
        int[] nums1 = new int[]{1, 2};
        solution20240611.searchRange(nums1, 8);
    }
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
    //找左右边界
    static class Solution20240611Wrong {
        public int[] searchRange(int[] nums, int target) {
            int left=0,right=nums.length-1;
            int mid=-1;
            int[] result=new int[]{-1,-1};
            while(left<=right){
                mid = (right-left)/2+left;
                if(nums[mid]==target){
                    break;
                }else if(nums[mid] >target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            if(mid==-1){
                return result;
            }
            int leftBound = left_bound(nums, target, mid);
            int rightBound = right_bound(nums, target, mid);
            result[0] = (leftBound);
            result[1] = (rightBound);
            return result;
        }
        public int left_bound(int[] nums, int target, int realMid){
            int left=0,right=realMid;
            int mid=0;
            while(left<=right){
                System.out.println(left + "###" + right);
                mid = (right-left)/2+left;
                if(nums[mid] ==target){
                    right = mid-1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            return left;
        }
        public int right_bound(int[] nums, int target, int realMid){
            int left=0,right=realMid;
            int mid = 0;
            while(left<=right){
                System.out.println(left + "###" + right);
                if(nums[mid] == target){
                    left = mid+1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            return right;
        }
    }

    //找左右边界
//时隔多日再做，一开始很抵触，一想到有很多细节要处理就心烦，经过了一整天的心理建设以后，算是独立写出来了吧，所以还是要戒骄戒躁，心态很重要
//反正我就回忆起一点，找左边界，就返回left，找右边界，就返回right，无他，经验尔
//独立做完后，感觉也没labuladong说的那么玄乎，什么要处理细节，什么要决定用开还是闭区间。别考虑太多直接干，遇到问题再调试解决吧，你不能指望把这些细节都记下来，那样成本太高了
    class Solution202406111742 {
        public int[] searchRange(int[] nums, int target) {
            int left=0,right=nums.length-1;
            int mid=-1;
            boolean founded = false;
            int[] result=new int[]{-1,-1};
            while(left<=right){
                mid = (right-left)/2+left;
                if(nums[mid]==target){
                    founded = true;
                    break;
                }else if(nums[mid] >target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            if(!founded){
                return result;
            }
            int leftBound = left_bound(nums, target, mid);
            int rightBound = right_bound(nums, target, mid);
            result[0] = (leftBound);
            result[1] = (rightBound);
            return result;
        }
        public int left_bound(int[] nums, int target, int realMid){
            int left=0,right=realMid;
            int mid=0;
            while(left<=right){
                //System.out.println(left + "###" + right);
                mid = (right-left)/2+left;
                if(nums[mid] ==target){
                    right = mid-1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            return left;
        }
        public int right_bound(int[] nums, int target, int realMid){
            //System.out.println(realMid);
            // int left=0,right=realMid;
            int left=realMid, right=nums.length-1;
            int mid = 0;
            while(left<=right){
                //System.out.println(left + "###" + right);
                //执行超时，原来是忘了计算mid的值。。。。
                mid = (right-left)/2+left;
                if(nums[mid] == target){
                    left = mid+1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            return right;
        }
    }

    class Solution20240612 {
        public int[] searchRange(int[] nums, int target) {
            int left=0,right = nums.length-1,mid=-1;
            boolean targetFounded = false;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]==target){
                    targetFounded=true;
                    break;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid +1;
                }
            }
            //至此，mid指向的是target在数组中心的位置，接下来以这个位置为界限，在左右两边找左右边界

            int[] result = new int[]{-1,-1};
            //需要特殊处理没找到的情况
            if(!targetFounded){
                return result;
            }
            result[0]=leftBound(nums,target,mid);
            result[1]=rightBound(nums,target,mid);
            return result;
        }
        public int leftBound(int[] nums, int target, int firstMid){
            int left=0,right=firstMid,mid=-1;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]>=target){
                    right = mid-1;
                }else if(nums[mid]<target){
                    left = mid+1;
                }
            }
            return left;
        }
        public int rightBound(int[] nums, int target, int firstMid){
            //注意求右边界时，区间的起始点
            int left = firstMid,right=nums.length-1,mid=-1;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]<=target){
                    left=mid+1;
                }else if(nums[mid]>target){
                    right = mid-1;
                }
            }
            return right;
        }
    }
//寻找左右边界的结合体，我认为相当经典
//调完直接提交，都没先运行一下，就是这么狂，哈哈哈哈哈哈

}