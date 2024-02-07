/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC572_subtree_of_another_tree
 * Date Created : 2024-02-07
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-07       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: 返回布尔值的题，在函数返回前往往需要将左右子树都判断一下，见下面注释掉的痕迹，是自己犯的错
 * @author: Admin
 * @create: 2024-02-07
 **/
public class LC572_subtree_of_another_tree {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{3,4,5,1,2});
        TreeNode subRoot = Tools.treeCreater(new int[]{4,1,2});
        Solution solution = new Solution();

        System.out.println(solution.isSubtree(root, subRoot));
    }
    static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root==null){
                return false;
            }
            if(root.val == subRoot.val){
                if(judge(root, subRoot)){
                    return true;
                }
            }
            /*isSubtree(root.left, subRoot);
            isSubtree(root.right, subRoot);
            return false;*/
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        public boolean judge(TreeNode root1, TreeNode root2){
            if(root1==null&&root2==null){
                return true;
            }
            if(root1==null && root2!=null){
                return false;
            }
            if(root1!=null && root2==null){
                return false;
            }
            if(root1.val != root2.val){
                return false;
            }
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);
        }
    }
}