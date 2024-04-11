/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC113_path_sum_ii
 * Date Created : 2024-02-13
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-13       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题自己独立做出来的，只是list.remove方法不太熟练，且忘了需要在add前先new list
 * @author: Admin
 * @create: 2024-02-13
 **/
public class LC113_path_sum_ii {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            findPath(root, targetSum);
            return result;
        }
        public void findPath(TreeNode root,int targetSum){
            if(root==null){
                return;
            }
            currentPath.add(root.val);
            if(root.left==null&&root.right==null){
                if(root.val == targetSum){
                    //这里没用new，导致最后的结果是空的，好在自己独立发现并改正了
                    result.add(new ArrayList<>(currentPath));
                }
            }
            findPath(root.left,targetSum-root.val);
            findPath(root.right,targetSum-root.val);
            currentPath.remove(currentPath.size()-1);
        }
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution20240411 {
        List<List<Integer>> result  = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            backtrack(root, targetSum);
            return result;
        }
        public void backtrack(TreeNode root, int targetSum){
            //回溯终止条件
            if(root==null){
                return;
            }
            track.addLast(root.val);
            if(root.val == targetSum && root.left==null && root.right==null){
                //track.addLast(root.val);
                result.add(new ArrayList<Integer>(track));
                //track.removeLast();
                //不能return，应该是这里提前return了导致后面的removeLast没执行，导致case1 多一个元素4？
                //是的，就是不能return，既然回溯的终止条件是root==null，那就要让每次回溯都去触发结束条件才结束，而不能在这里提前结束，先算作一个记忆点吧
                //return;
            }
            //track.addLast(root.val);
            backtrack(root.left, targetSum-root.val);
            //track.removeLast();

            //track.addLast(root.val);
            backtrack(root.right, targetSum-root.val);
            //track.removeLast();
            track.removeLast();
        }
    }
}