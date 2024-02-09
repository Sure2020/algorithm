/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1038_binary_search_tree_to_greater_sum_tree
 * Date Created : 2024-02-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-10       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-10
 **/
public class LC1038_binary_search_tree_to_greater_sum_tree {
    class Solution {
        int sum = 0;
        public TreeNode bstToGst(TreeNode root) {
            inOrder(root);
            return root;
        }
        public void inOrder(TreeNode root){
            if(root==null){
                return;
            }
            inOrder(root.right);

            sum += root.val;
            root.val = sum;
            inOrder(root.left);
        }
    }
}