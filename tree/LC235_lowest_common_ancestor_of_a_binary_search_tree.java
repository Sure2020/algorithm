/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC235_lowest_common_ancestor_of_a_binary_search_tree
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
public class LC235_lowest_common_ancestor_of_a_binary_search_tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //确保val1比val2小
            int val1 = Math.min(p.val, q.val);
            int val2 = Math.max(p.val, q.val);
            return dfs(root, val1, val2);

        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root==null){
                return null;
            }
            //如果当前节点值比小的值还小，就去右子树找
            if(root.val<val1){
                return dfs(root.right, val1,val2);
            }
            //如果当前节点的值比大的值还大，就去左子树找
            if(root.val>val2){
                return dfs(root.left, val1, val2);
            }
            //此时val1<=root.val<=val2，说明root就是LCA
            return root;
        }
    }
}