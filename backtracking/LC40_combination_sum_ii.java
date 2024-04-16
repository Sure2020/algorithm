/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC40_combination_sum_ii
 * Date Created : 2024-04-16
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-16       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-16
 **/
public class LC40_combination_sum_ii {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(0, candidates, target);
            return res;
        }
        public void backtrack(int start, int[] candidates, int target){
            //base case
            if(trackSum == target){
                res.add(new ArrayList(track));
                return;
            }
            //和超过了则不干了，直接结束
            if(trackSum>target){
                return;
            }
            for(int i=start; i<candidates.length; i++){
                //出现[[1,2,5],[1,7],[1,6,1],[2,6],[2,1,5],[7,1]]，应该是没把重复的元素跳过，所以：
                if(i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                track.add(candidates[i]);
                trackSum += candidates[i];
                backtrack(i+1, candidates, target);
                track.removeLast();
                trackSum -= candidates[i];
            }
        }
    }
}