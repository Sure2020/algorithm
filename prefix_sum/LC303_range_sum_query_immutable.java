/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC303_range_sum_query_immutable
 * Date Created : 2024-02-22
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-22       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-22
 **/
public class LC303_range_sum_query_immutable {
    class NumArray {
        int[] preNums;
        public NumArray(int[] nums) {
            this.preNums = new int[nums.length+1];
            for(int i=1;i<preNums.length;i++){
                preNums[i]=preNums[i-1]+nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return preNums[right+1]-preNums[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}