/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC104_maximum_depth_of_binary_tree
 * Date Created : 2023-10-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-27       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-27
 **/
public class LC104_maximum_depth_of_binary_tree {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);

        //System.out.println(maxDepth(root));
        System.out.println(recurse(root));

        res=0;

        System.out.println("case2");
        TreeNode tempNode2 = new TreeNode();
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        //System.out.println(maxDepth(root2));
        System.out.println(recurse(root2));

    }
    // 记录最大深度
    static int res = 0;
    // 记录遍历到的节点的深度
    static int depth = 0;

    // 主函数
    static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    static int recurse(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = recurse(root.left);
        int right = recurse(root.right);
        return Math.max(left, right)+1;
    }

    // BFS
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i< size; i++){
                TreeNode currentNode = q.poll();
                if(currentNode.left == null&& currentNode.right==null){
                    return depth;
                }
                if(currentNode.left!=null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    q.offer(currentNode.right);
                }

            }
            depth ++;
        }
        return depth;
    }

    //第三次做，独立解出来，只改了一次。记录一下
    class Solution {
        int result = 0;
        public int maxDepth(TreeNode root) {
            return dfs(root,1);
        }
        public int dfs(TreeNode root, int currentDepth){
            if(root==null){
                return 0;
            }
            if(root.left==null&&root.right==null){

                result = Math.max(result, currentDepth);
            }
            dfs(root.left, currentDepth+1);
            dfs(root.right,currentDepth+1);
            return result;
        }
    }

    //自己竟然直接写出来了，一次通过，得益于对前序位置和后序位置的理解吧
    class Solution20240313 {
        int maxDepth = 0;
        int currentDepth = 0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            //前序位置
            currentDepth++;
            maxDepth = Math.max(currentDepth, maxDepth);
            maxDepth(root.left);
            maxDepth(root.right);
            //后序位置
            currentDepth--;
            return maxDepth;
        }
    }

    //先哈哈
    //果然没打脸，自己秒杀了，毕竟简单题。诀窍是弄清楚递归函数的定义
    class Solution20240529 {
        // int result = 0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int result = Math.max(left,right) + 1;
            return result;
        }
    }

    //分解的思路
    class Solution20240530 {
        private int result = 0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            result = Math.max(left,right)+1;
            return result;
        }
    }

    //递归的思路试试：
    //事后：相当于秒杀了~~~
    class Solution20240606 {
        int result=0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            max(root, 0);
            return result;
        }
        public void max(TreeNode root, int currentDepth){
            if(root==null){
                return ;
            }
            currentDepth++;
            result = Math.max(result, currentDepth);
            max(root.left, currentDepth);
            max(root.right, currentDepth);
        }
    }

    class Solution20240710 {
        int result = 0;

        public int maxDepth(TreeNode root) {
            max(root, 0);
            return result;
        }
        public void max(TreeNode root, int currentMax){
            //base case
            if(root==null){
                return ;
            }
            currentMax ++;
            if(root.left==null && root.right==null){
                result = Math.max(result, currentMax);
                // currentMax=0;
            }
            max(root.left, currentMax);
            max(root.right, currentMax);
        }
    }

    class Solution20240801 {
        int result = 0;
        //int currentMax = 0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            max(root,1);
            return result;
        }
        public void max(TreeNode root, int currentMax){
            if(root==null){
                return ;
            }
            System.out.println(root.val);
            if(root.left==null && root.right==null){
                //挑战一下max，这里犯傻了，应该取两者最大值，而不是直接赋值！
                result = Math.max(result, currentMax);
                //System.out.println("ok: " + currentMax);
                return;
            }
            max(root.left,currentMax+1);
            max(root.right, currentMax+1);
        }
    }
//递归的入门级
//事后：小看人，还说人家入门级，结果卡了一下子
//求最大值的问题，给result赋值要用Math.max挑战后赋值，而不是直接赋值！

    class Solution20240803 {
        public int maxDepth(TreeNode root) {
            return height(root,1);
        }
        public int height(TreeNode root,int currentHeight){
            //base case
            if(root==null){
                return 0;
            }
            //base case
            if(root.left==null && root.right==null){
                return 1;
            }
            int left = height(root.left, currentHeight+1);
            int right = height(root.right, currentHeight+1);
            return(Math.max(left, right)+1);
        }
    }

//以后就用这种方式求最值，就是避免用全局变量，全局变量容易影响别的东西。

    class Solution20241128 {
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            if(root.left==null && root.right==null){
                return 1;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }

    }
//以后就用这种方式求最值，就是避免用全局变量，全局变量容易影响别的东西。
//看了labuladong，原来这个思路叫动态规划，还有个回溯的思路，暂不研究吧

    class Solution20250513 {
        int result = 0;
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            if(root.left==null && root.right==null){
                return 1;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }
}