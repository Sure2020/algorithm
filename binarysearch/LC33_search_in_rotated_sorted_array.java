/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC33_search_in_rotated_sorted_array
 * Date Created : 2024-03-29
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-29       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-29
 **/
public class LC33_search_in_rotated_sorted_array {
    class Solution {
        public int search(int[] nums, int target) {
            if(nums==null){
                return -1;
            }
            int left=0,right=nums.length-1;
            int mid=0;
            while(left<=right){
                mid = left+(right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }
                //mid在左边有序的部分
                else if(nums[mid]>=nums[left]){
                    //判断target是否在这个区间，不在就别搜索了，能节省时间。一开始只写了个if nums[mid]>target的条件
                    if(nums[mid]>target && nums[left]<=target){
                        right=mid-1;
                    }
                    //否则就去断崖的另一边去找了
                    else{
                        left=mid+1;
                    }
                }
                //mid在右边，就把区间锁定到右边一部分有序的区间
                else if(nums[mid]<nums[left]){
                    left=mid+1;
                }
            }
            return -1;
        }
    }
}