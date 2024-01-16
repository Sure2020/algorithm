/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC153_find_minimum_in_rotated_sorted_array_ii
 * Date Created : 2024-01-16
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-16       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-16
 **/
public class LC153_find_minimum_in_rotated_sorted_array_ii {
    public int findMin(int[] nums) {
        int left = 0,right=nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }else if (nums[mid]>nums[right]){
                left = mid+1;
            } else{
                right--;
            }
        }
        return nums[left];

    }
}