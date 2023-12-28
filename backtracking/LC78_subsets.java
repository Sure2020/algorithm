/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC78_subsets
 * Date Created : 2023-12-28
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-28       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-28
 **/
public class LC78_subsets {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> track = new LinkedList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        subsets(nums);
        System.out.println(result);

    }
    // track
    // chose
    // end case
    public static List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0);
        return result;
    }
    public static void backtrack(int[] nums, int start){
        result.add(new LinkedList<>(track));
        for (int i=start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}