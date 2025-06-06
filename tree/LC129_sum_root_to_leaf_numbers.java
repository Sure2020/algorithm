/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC129_sum_root_to_leaf_numbers
 * Date Created : 2024-02-02
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-02       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-02
 **/
public class LC129_sum_root_to_leaf_numbers {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        /*tempNode = root.right;
        tempNode.right = new TreeNode(3);

        tempNode = root.left;
        tempNode.left = new TreeNode(3);*/

        TreeNode tempNode2 = new TreeNode();
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        tempNode2 = root2.left;
        tempNode2.left = new TreeNode(5);
        tempNode2.right = new TreeNode(1);

        /*traverse(root);
        System.out.println(path);
        System.out.println(allPath);*/
        System.out.println(sumNumbers(root));
        System.out.println(sumNumbers(root2));

        System.out.println(sumNumbers2(root));
        System.out.println(sumNumbers2(root2));
        /*traverseReversely(root);
        System.out.println(pathReversely);
        System.out.println(allPathReversely);*/
        System.out.println("#######");
        Solution20240331 solution20240331 = new Solution20240331();
        System.out.println(solution20240331.sumNumbers(root));
    }
    //LinkedList<Integer> path = new LinkedList();
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> allPath = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {
        traverse(root);
        //System.out.println(allPath);
        int sum = 0;
        for(int i=0;i<allPath.size();i++){
            List<Integer> tempPath = allPath.get(i);
            int tempCount = tempPath.size()-1;
            for (int j =0; j< tempPath.size(); j++){
                sum +=  tempPath.get(j)*Math.pow(10,tempCount);
                tempCount --;
            }
        }
        return sum;
    }

    // self, right
    public static void traverse(TreeNode root){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left == null&& root.right==null){
            allPath.add(new ArrayList<>(path));
            //path.remove(path.size()-1);
        }
        traverse(root.left);
        traverse(root.right);
        path.remove(path.size()-1);
    }


    // try failed
    static List<Integer> pathReversely = new ArrayList<>();
    static List<List<Integer>> allPathReversely = new ArrayList<>();
    public static void traverseReversely(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left == null&& root.right==null){
            pathReversely.add(root.val);
            //allPath.add(new ArrayList<>(path));
            //path.remove(path.size()-1);
        }
        traverseReversely(root.left);
        traverseReversely(root.right);
        allPathReversely.add(new ArrayList<>(pathReversely));

        //pathReversely.remove(path.size()-1);
    }


    // labuladong
    public static int sumNumbers2(TreeNode root) {
        traverse2(root);
        return sum;

    }
    static StringBuilder sb = new StringBuilder();
    static int sum = 0;
    public static void traverse2(TreeNode root){
        if(root==null){
            return;
        }
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            sum+=Integer.valueOf(sb.toString());
        }
        traverse2(root.left);
        traverse2(root.right);
        sb.deleteCharAt(sb.length()-1);
    }


    static class Solution20240331 {
        // 有意识地在用撤销选择的方法，结果没成功
        // 后来，看了labuladong的思路又不甘心，又调试了一会儿，结果成功了！我真厉害啊
        int result = 0;

        public int sumNumbers(TreeNode root) {
            // int result = 0;
            dfs(root, 0);
            return result;
        }

        public void dfs(TreeNode root, int currentSum) {
            if (root == null) {
                return;
            }
            // 这一步是关键，阻止继续向下传递*10
            if (root.left == null && root.right == null) {
                result = result + currentSum + root.val;
                return;
            }
            currentSum += root.val;
            dfs(root.left, currentSum * 10);
            dfs(root.right, currentSum * 10);
        }
    }

    //跟层数有关
    //base case是到达叶子节点
    //稀里糊涂，调试好久，算是独立解出
    class Solution202040603 {
        int result = 0;
        int current = 0;
        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root,0);
            return result;
        }
        //函数定义？不用了，这个是递归思路，不是分解思路，不用函数定义
        public void dfs(TreeNode root, int current){
            //System.out.println("###" + current);
            //base case
            if(root==null){
                return;
            }
            current = current * 10 + root.val;
            if(root.left==null && root.right==null){
                result += current;
                //System.out.println("###" + current+"###"+result);
                return;
            }
            //System.out.println("###" + current);

            //System.out.println(root.val + "###" + current+"###"+result);
            //System.out.println("###" + current);
            dfs(root.left,current);
            dfs(root.right,current);
        }
    }

    //递归的思路
    //多次做，还是不够流畅，但总结了诀窍是，代入一个case辅助思考即可
    class Solution20240606 {
        int result = 0;

        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            sum(root,0);
            return result;
        }
        public void sum (TreeNode root, int current){
            if(root==null){
                return;
            }
            current = current * 10 + root.val;
            //base case
            if(root.left==null && root.right==null){
                result += current;
                return;
            }

            sum(root.left, current);
            sum(root.right, current);
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
    class Solution20240710 {
        int result = 0;
        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            sum(root,0);
            return result;
        }
        public void sum(TreeNode root, int currentSum){
            //System.out.println("curremtSum: " + currentSum);
            //base case

            if(root==null){
                return;
            }
            int val = root.val;
            //System.out.println("val:: " + val);
            currentSum = currentSum*10 + val;
            if( root.left==null && root.right==null){
                result += currentSum;
                //System.out.println("result: " + result);
                return;
            }

            sum(root.left, currentSum);

            //System.out.println("left and right");
            sum(root.right,currentSum);
        }
    }
//递归的思路。
//也是调试了1个小时，总结起来就是，静下心来调试


    class Solution {
        int result = 0;
        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            sum(root,0);
            return result;
        }
        public void sum(TreeNode root, int current){
            if(root==null){
                return;
            }
            current = current * 10 + root.val;
            if(root.left==null && root.right==null){
                result += current;
                return;
            }
            sum(root.left, current);
            sum(root.right, current);
        }
    }
}