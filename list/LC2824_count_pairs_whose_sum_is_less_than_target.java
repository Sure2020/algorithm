/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC2824_count_pairs_whose_sum_is_less_than_target
 * Date Created : 2024-01-18
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-18       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Collections;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-18
 **/
public class LC2824_count_pairs_whose_sum_is_less_than_target {
    public int countPairs(List<Integer> nums, int target) {
        // int count = 0;
        // for(int i=0;i<nums.size();i++){
        //     for(int j = i+1;j<nums.size();j++){
        //         if(nums.get(i)+nums.get(j)<target){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        Collections.sort(nums);
        int count = 0;
        for(int left = 0, right=nums.size()-1;left<right;left++){
            while(right>left&&nums.get(left)+nums.get(right)>=target){
                right--;
            }
            count += right-left;
        }
        return count;
    }
}