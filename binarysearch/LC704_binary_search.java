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
    class Solution20240329 {
        public int search(int[] nums, int target) {
            if(nums==null){
                return -1;
            }
            int left=0,right=nums.length-1;

            while(left<=right){
                int mid = left+(right-left)/2;
                if(nums[mid]>target){
                    right=mid-1;
                }else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }

    //left,mid,right,长时间不写，乍一看还有点懵。。。
    class Solution20240611 {
        public int search(int[] nums, int target) {
            //right的取值忘了减1，在写的时候尽量想清楚，否则代码成型后再debug，就很难发现了
            int left=0,right=nums.length-1;
            int mid = 0;
            while(left<=right){
                // mid = (left+right)/2;
                // mid = left/2+right/2;
                mid = (right-left)/2+left;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left=mid+1;
                }
            }
            return -1;
        }
    }

    class Solution20240612 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=-1;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }else if (nums[mid]>target){
                    right=mid-1;
                }else if (nums[mid]<target){
                    left = mid+1;
                }
            }
            return -1;
        }
    }
//心如止水

    class Solution20240702 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return -1;
        }
    }

    class Solution20240801 {
        public int search(int[] nums, int target) {
            int left = 0,right = nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                //System.out.println("value: " + nums[mid]);
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            return -1;
        }
    }
//事后：有点惊险，原来是弄错了><号的方向

    class Solution20241127 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return -1;
        }
    }
//从中间开始，二分查找

    class Solution20250513 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return -1;
        }
    }

    class Solution20250525 {
        public int search(int[] nums, int target) {
            int left=0,right=nums.length-1,mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]>=target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            return -1;
        }
    }
}