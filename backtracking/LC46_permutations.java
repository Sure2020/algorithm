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
public class LC46_permutations {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {

        // remove element in LinkedList is easy, so here use LinkedList instead of List
        //List<Integer> track = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return result;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // end case
        if (track.size() == nums.length) {
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
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
    class Solution20240410 {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            //track用链表，因为会频繁删除和插入，且链表有removeLast方法
            LinkedList<Integer> track = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            backtrack(nums, track, used);
            return res;
        }
        public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used){
            if(track.size() == nums.length){
                res.add(new ArrayList(track));
                return;
            }
            for(int i = 0;i<nums.length;i++){
                //这里如果期望used[i]的值为false，执行完后面的逻辑，下一次backtrack时used[i]为true,会陷入死循环
                //这里去判断user[i]为true就continue，无非就是代码嵌套层数少，美观。没其他原因，自己想复杂了，之所以有上面的说法，是自己没把回溯的逻辑也写入大括号此
                // if(!used[i]){
                //     track.add(nums[i]);
                // }
                if(used[i]){
                    continue;
                }
                track.add(nums[i]);
                used[i]=true;
                backtrack(nums, track, used);
                track.removeLast();
                used[i]=false;
            }
        }
    }

    class Solution20240416 {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }
        public void backtrack(int[] nums){
            //base case
            if(track.size() == nums.length){
                res.add(new ArrayList(track));
                return;
            }
            for(int i=0;i<nums.length;i++){
                //这里去判断user[i]为true就continue，无非就是代码嵌套层数少，美观。没其他原因，自己想复杂了
                if(!used[i]){
                    //continue;
                    track.add(nums[i]);
                    used[i]=true;
                    backtrack(nums);
                    track.removeLast();
                    used[i]=false;
                }
            }
        }
    }
}