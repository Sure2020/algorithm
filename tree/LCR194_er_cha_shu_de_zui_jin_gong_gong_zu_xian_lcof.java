/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR194_er_cha_shu_de_zui_jin_gong_gong_zu_xian_lcof
 * Date Created : 2024-02-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LCR194_er_cha_shu_de_zui_jin_gong_gong_zu_xian_lcof {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p.val, q.val);
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root == null){
                return null;
            }
            //对应情况2
            if (root.val == val1 ||root.val == val2) {
                return root;
            }
            TreeNode left = dfs(root.left, val1, val2);
            TreeNode right = dfs( root.right, val1, val2);
            if(left != null && right !=null){
                return root;
            }
            //对应情况1
            return left!= null ? left:right;
        }
    }
}