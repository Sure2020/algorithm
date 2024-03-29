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
    //这是自己独立写出来的思路，虽然不如官解简洁，但仍然选择自己的思路，减少记忆成本
    class Solution20240329 {
        public int findMin(int[] nums) {
            if(nums==null || nums.length==0){
                return -50001;
            }

            int left =0,right = nums.length-1;
            int mid = 0;
            int min = 50001;
            if(nums[left]<nums[right]){
                return nums[left];
            }
            while(left<=right){
                mid = left+(right-left)/2;
                min = Math.min(min, nums[mid]);
                // System.out.println(left + "#"+right);
                // System.out.println("#"+nums[mid]+"#");
                //mid在左边升序的区间，记下左区间的最小值，再去右边的无序区间去找
                if(nums[mid]>=nums[left]){
                    min = Math.min(min, nums[left]);
                    left = mid+1;
                }
                //mid的右边有序
                else if(nums[mid]<=nums[right]){
                    min = Math.min(min, nums[left]);

                    right = mid-1;
                }
            }
            return min;
        }
    }
}