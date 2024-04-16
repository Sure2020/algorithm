/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC47_permutations_ii
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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-17
 **/
public class LC47_permutations_ii {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            //sort
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }
        public void backtrack(int[] nums){
            //base case
            if(track.size()==nums.length){
                res.add(new ArrayList(track));
                return;
            }
            for(int i = 0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                //剪枝
                //我想不到的技巧：这里的剪枝逻辑增加了!used[i-1],是为了只选重复元素固定相对位置的排列，比如只要2->2`->2``的排列，只有当前一个2用过了，才选这个2`，这样就能保证相对位置固定。
                if(i!=0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                track.add(nums[i]);
                used[i]=true;
                backtrack(nums);
                track.removeLast();
                used[i]=false;
            }
        }
    }
}