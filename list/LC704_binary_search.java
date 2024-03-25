/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC704_binary_search
 * Date Created : 2024-01-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-11
 **/
public class LC704_binary_search {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1, mid=0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return -1;
    }

    class Solution20240218 {
        public int search(int[] nums, int target) {
            //一开始写成了right=nums.length忘了减1
            //忘了初始化为0
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]<target){
                    left=mid+1;
                }
                if(nums[mid]>target){
                    right=mid-1;
                }
                //两个等号写成了一个
                if(nums[mid]==target){
                    return mid;
                }
            }
            return -1;
        }
    }

    class Solution20240325 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1;
            int mid = 0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]<target){
                    left=mid+1;
                }else if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    right=mid-1;
                }
            }
            return -1;

        }
    }
}