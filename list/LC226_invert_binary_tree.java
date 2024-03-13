/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC226_invert_binary_tree
 * Date Created : 2024-01-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-19       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-19
 **/
public class LC226_invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    // public TreeNode invertTree(TreeNode root) {
    //     traverse(root);
    //     return root;
    // }
    // public void traverse(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     TreeNode tempNode = root.left;
    //     root.left = root.right;
    //     root.right = tempNode;
    //     traverse(root.left);
    //     traverse(root.right);
    // }
    //吹一波，这题自己看完十几秒就独立、一次性解出，但毕竟是简单题目，还是别太高兴
    class Solution20240314 {
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return null;
            }
            invertTree(root.left);
            invertTree(root.right);
            //实践发现交换的动作放在前序还是后序位置，都可以
            TreeNode tempNode = root.left;
            root.left=root.right;
            root.right=tempNode;
            return root;
        }
    }
}