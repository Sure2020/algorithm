/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : BinarySearchFrame
 * Date Created : 2024-02-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-19       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-19
 **/
public class BinarySearchFrame {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,4,4,5,6,7};
        System.out.println(binarySearch(nums, 4));
        System.out.println(leftBound(nums, 4));
        System.out.println(rightBound(nums, 4));
    }
    public static int binarySearch(int[] nums, int target){
        int left=0,right=nums.length-1,mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }
    public static int leftBound(int[] nums, int target){
        int left =0,right=nums.length-1,mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]==target){
                // 这里是独特的地方，锁定左边界，收缩右边界
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        //这里是独特的地方，比较left
        if(left<0||left>=nums.length){
            return -1;
        }
        return nums[left]==target?left:-1;
    }
    public static int rightBound(int[] nums, int target){
        int left=0,right=nums.length-1,mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]==target){
                //这里是独特的地方，锁定右边界，收缩左边界
                left = mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        //这里是独特的地方，比较right
        if(right<0||right>=nums.length){
            return -1;
        }
        return nums[right]==target?right:-1;
    }
}