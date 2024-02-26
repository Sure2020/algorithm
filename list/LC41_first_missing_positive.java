/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC41_first_missing_positive
 * Date Created : 2024-02-27
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-27       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题不愧是困难题，好几处思路我承认自己根本想不到，牢记思路吧。
 * @author: Admin
 * @create: 2024-02-27
 **/
public class LC41_first_missing_positive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for(int i=0;i<nums.length;i++){
                // 下面不应是if，而应是while
                while(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
                    swapTwo(nums,i, nums[i]-1);
                }
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    return i+1;
                }
            }
            return nums.length+1;
        }
        public void swapTwo(int[] nums, int index1, int index2){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2]=temp;
        }
    }
}