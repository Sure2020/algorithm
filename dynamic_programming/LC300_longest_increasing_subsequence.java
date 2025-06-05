/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC300_longest_increasing_subsequence
 * Date Created : 2025-06-01
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2025-06-01       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Arrays;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2025-06-01
 **/
public class LC300_longest_increasing_subsequence {
    class Solution20250601 {
        public int lengthOfLIS(int[] nums) {
            int dp[]=new int[nums.length];
            Arrays.fill(dp,1);
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j]){
                        dp[i]=Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            int result = 0;
            for(int i=0;i<nums.length;i++){
                result = Math.max(dp[i], result);
            }
            return result;
        }
    }

    class Solution20250605 {
        public int lengthOfLIS(int[] nums) {
            // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
            int dp[] = new int[nums.length];
            // base case：dp 数组全都初始化为 1
            Arrays.fill(dp,1);
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            int result = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                result = Math.max(dp[i], result);
            }
            return result;
        }
    }

}