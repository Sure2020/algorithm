/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC236_
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
 * 注意给出的提示，因为提示中说了，p和q一定存在于树中，所以如果root节点还没遍历，一开始就匹配到了其中一个节点，那这个节点就是LCA
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC236_lowest_common_ancestor_of_a_binary_tree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p.val, q.val);
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root ==null){
                return null;
            }
            //因为提示中说了，p和q一定存在于树中，所以如果root节点还没遍历，一开始就匹配到了其中一个节点，那这个节点就是LCA
            if(root.val == val1 || root.val == val2){
                return root;
            }
            TreeNode left = dfs(root.left, val1, val2);
            TreeNode right = dfs(root.right, val1, val2);
            if(left != null && right != null){
                return root;
            }
            return left != null ?left:right;
        }
    }
    class Solution20240215 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p.val,q.val);
        }
        public TreeNode dfs(TreeNode root, int val1, int val2){
            if(root==null){
                return null;
            }
            if(root.val==val1||root.val==val2){
                return root;
            }
            TreeNode left = dfs(root.left,val1,val2);
            TreeNode right = dfs(root.right,val1,val2);
            if(left!=null&&right!=null){
                return root;
            }
            return left!=null?left:right;
        }
    }
    //这题，第三次再遇到，只有个模糊的印象，知道有3种情况，其实只要记住，就是去子树中找p或者q节点，写出find函数后面就水到渠成了
    class Solution20240313 {
        //分3种情况，1。两节点都在当前节点的子树中；2.两节点都不在；3.一个在，一个不在
        //这题，第三次再遇到，只有个模糊的印象，知道有3种情况，其实只要记住，就是去子树中找p或者q节点，写出find函数后面就水到渠成了
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return null;
            }
            if(root.val==p.val || root.val==q.val){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right = lowestCommonAncestor(root.right, p,q);
            if(left!=null && right !=null){
                return root;
            }
            return left!=null ? left:right;
        }
    }
}