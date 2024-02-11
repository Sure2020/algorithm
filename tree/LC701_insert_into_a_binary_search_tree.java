/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC701_insert_into_a_binary_search_tree
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
 * BST的插入操作，学来的
 * @author: Admin
 * @create: 2024-02-11
 **/
public class LC701_insert_into_a_binary_search_tree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null){
                return new TreeNode(val);
            }
            if(val > root.val){
                root.right = insertIntoBST(root.right, val);
            }
            if(val < root.val){
                root.left = insertIntoBST(root.left, val);
            }
            //根据题意，不会存在val. = root.val
            return root;
        }
    }
}