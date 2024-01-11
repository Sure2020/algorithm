/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC35_search_insert_position
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
public class LC35_search_insert_position {
    public static void main(String[] args) {
        System.out.println("test");
        int[] nums = new int[]{1,2};
        System.out.println(nums.length);

    }
    public int searchInsert(int[] nums, int target) {
        // for(int i = 0;i<nums.length;i++){
        //     if(nums[i]>=target){
        //         return i;
        //     }
        // }
        // return nums.length;
        int left = 0,right = nums.length-1,mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[right]>target){
                right = mid-1;
            }
        }
        return left;
    }
}