/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1644_lowest_common_ancestor_of_a_binary_tree_ii
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
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC1644_lowest_common_ancestor_of_a_binary_tree_ii {
    class Solution {
        boolean findP=false,findQ=false;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode result =  dfs(root, p.val, q.val);
            if(!findP||!findQ){
                return null;
            }
            //注意这里搞错了，需要先执行dfs再判断findP和findQ
            //return dfs(root, p.val, q.val);
            return result;
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root==null){
                return null;
            }
            TreeNode left = dfs(root.left, val1, val2);
            TreeNode right = dfs (root.right, val1, val2);

            /*if(root.val == val1){
                findP = true;
            }
            if(root.val == val2){
                findQ = true;
            }*/
            if (root.val ==val1||root.val==val2){
                if(root.val == val1){
                    findP = true;
                }
                if(root.val == val2){
                    findQ = true;
                }
                //牢记是在公共祖先框架代码上改，注意下面这两个判断条件，漏掉了return root，我第一次写就漏掉了
                return root;
            }
            if(left!=null && right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
}