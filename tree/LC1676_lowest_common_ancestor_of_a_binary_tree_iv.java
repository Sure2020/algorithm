/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1676_lowest_common_ancestor_of_a_binary_tree_iv
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

import java.util.HashSet;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC1676_lowest_common_ancestor_of_a_binary_tree_iv {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            //将数组转换成hashset方便判断元素是否包含在内
            HashSet<Integer> hashSet = new HashSet<>();
            for(TreeNode node : nodes){
                hashSet.add(node.val);
            }
            return dfs(root,  hashSet);
        }
        public TreeNode dfs(TreeNode root, HashSet<Integer> nodes){
            if(root==null){
                return null;
            }
            if(nodes.contains(root.val)){
                return root;
            }
            TreeNode left=dfs(root.left, nodes);
            TreeNode right=dfs(root.right, nodes);
            if(left!=null && right != null){
                return root;
            }
            return left!=null?left:right;
        }
    }
}