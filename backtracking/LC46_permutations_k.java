/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC46_permutations
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
public class LC46_permutations_k {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums,2));
    }

    public static List<List<Integer>> permute(int[] nums, int k) {

        // remove element in LinkedList is easy, so here use LinkedList instead of List
        //List<Integer> track = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used,k);
        return result;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used, int k) {
        // end case
        if (track.size() ==k) {
            /*List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i< nums.length;i++){
                tempList.add(track.get(i));
            }*/

            // attention, before add , new a LinkedList first,because elements in track list will be removed all later
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used,k);
            track.removeLast();
            used[i] = false;
        }
    }
}