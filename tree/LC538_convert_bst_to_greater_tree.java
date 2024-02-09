/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC538_convert_bst_to_greater_tree
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
 * 将中序遍历升序变降序的技巧值得称奇
 * @author: Admin
 * @create: 2024-02-10
 **/
public class LC538_convert_bst_to_greater_tree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = Tools.treeCreater(new int[]{1,4,6});
        System.out.println(solution.convertBST(root));
    }
    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            inOrder(root);
            return root;
        }
        int sum = 0;
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