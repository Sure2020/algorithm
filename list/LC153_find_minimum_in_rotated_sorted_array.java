/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC153_find_minimum_in_rotated_sorted_array
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
public class LC153_find_minimum_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int low = 0, high=nums.length-1, mid = 0;
        while(low < high){
            mid = low+(high-low)/2;
            if(nums[mid]<nums[high]){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return nums[low];
    }
}