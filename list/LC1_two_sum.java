/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1_two_sum
 * Date Created : 2024-02-24
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-24       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-24
 **/
public class LC1_two_sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> valToIndex = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                int need = target - nums[i];
                if(valToIndex.containsKey(need)){
                    return new int[]{valToIndex.get(need), i};
                }
                valToIndex.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}