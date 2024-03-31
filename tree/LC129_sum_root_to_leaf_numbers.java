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


    class Solution20240331 {
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
}