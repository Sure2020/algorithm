/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC144_binary_tree_preorder_traversal
 * Date Created : 2023-12-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-14       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-14
 **/
public class LC144_binary_tree_preorder_traversal {
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("case1");
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);
        preorderTraversal(root);

        System.out.println("case2");
        TreeNode tempNode2 = new TreeNode();
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        result.clear();
        preorderTraversal(root2);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        Tools.listPriter(result);
        return result;

    }
    public static void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
    class Solution20240310 {
        List<Integer> resultList = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {

            if(root==null){
                return new ArrayList<Integer>();
            }
            resultList.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return resultList;
        }
    }

    //哈哈
    class Solution20240529 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }

    //秒
    class Solution20240606 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }

    class Solution20240711 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }

    class Solution20240802 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {

            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }

    class Solution20241128 {
        List<Integer> result = new ArrayList<Integer>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }

    class Solution20250513 {
        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }
}