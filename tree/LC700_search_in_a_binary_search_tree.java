/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC700_search_in_a_binary_search_tree
 * Date Created : 2024-02-11
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-11       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 注意利用BST的左小右大的特性，正当自己为一次通过而得意时，看了labuladong的题解才发现自己写的是普通的二叉树搜索，尴尬了
 * @author: Admin
 * @create: 2024-02-11
 **/
public class LC700_search_in_a_binary_search_tree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root==null){
                return null;
            }
            if(root.val == val){
                return root;
            }
            if(root.val < val){
                return searchBST(root.right, val);
            }
            if(root.val > val){
                return searchBST(root.left,val);
            }
            return null;
        }
        public TreeNode searchBST_single(TreeNode root, int val) {
            if(root==null){
                return null;
            }
            if(root.val==val){
                return root;
            }
            TreeNode left = searchBST(root.left,val);
            TreeNode right = searchBST(root.right, val);
            return left!=null ? left:right;
        }
    }
}