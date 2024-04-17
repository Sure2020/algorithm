/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC39_combination_sum
 * Date Created : 2024-04-17
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-17       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-17
 **/
public class LC39_combination_sum {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target, 0);
            return res;
        }
        public void backtrack(int[] candidates, int target, int start){
            if(trackSum == target){
                res.add(new ArrayList(track));
                return;
            }
            //跳过不操作进行的情况
            if(trackSum>target){
                return;
            }
            for(int i=start;i<candidates.length;i++){
                track.add(candidates[i]);
                trackSum+=candidates[i];
                backtrack(candidates, target, i);
                track.removeLast();
                trackSum-=candidates[i];
            }
        }
    }
}