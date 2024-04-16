/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC90_subsets_ii
 * Date Created : 2023-12-31
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-31       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-31
 **/
public class LC90_subsets_ii {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        subsets(nums);
        System.out.println(result);

    }

    // track
    // chose
    // end case
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    public static void backtrack(int[] nums, int start) {
        result.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    class Solution20240416 {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //先排序，让值相同的元素相邻
            Arrays.sort(nums);
            backtrack(0,nums);
            return res;
        }
        public void backtrack(int start, int[] nums){
            res.add(new ArrayList(track));
            for(int i=start;i<nums.length;i++){
                //相邻的元素值相同，不再遍历
                if(i>start && nums[i]==nums[i-1]){
                    continue;
                }
                track.add(nums[i]);
                backtrack(i+1, nums);
                track.removeLast();
            }
        }
    }
}