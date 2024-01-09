/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC543_diameter_of_binary_tree
 * Date Created : 2023-11-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-15       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-15
 **/
public class LC543_diameter_of_binary_tree {
    private static int maxLength = 0;

    public static void main(String[] args) {

        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        tempNode = root.left;
        tempNode.left = new TreeNode(4);
        tempNode.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //maxPathLength(root);
        maxDepth2(root);
        return maxLength;
    }

    public static void maxPathLength(TreeNode root) {
        if (root == null) {
            return ;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxLength = Math.max(left + right, maxLength);
        maxPathLength(root.left);
        maxPathLength(root.right);
    }


    static int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
    static int maxDepth2(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        maxLength = Math.max(left + right, maxLength);
        return Math.max(left, right)+1;
    }
}