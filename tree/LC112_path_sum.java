/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC112_path_sum
 * Date Created : 2024-02-13
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-13       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 需要确定参数的初始值时，可以用代入法验证一下。labuladong的思路显然更有技巧性，但我没想到，不强求
 * @author: Admin
 * @create: 2024-02-13
 **/
public class LC112_path_sum {
    public static void main(String[] args) {
        Solution20240213 solution = new Solution20240213();
        TreeNode root = Tools.treeCreater(new int[]{1,2,3});
        System.out.println( solution.hasPathSum(root, 5));
    }
    class Solution {
        // int myTargetSum = 0;
        // int currentSum = 0;
        // public boolean hasPathSum(TreeNode root, int targetSum) {
        //     // if(root==null&&targetSum==0){
        //     //     return false;
        //     // }
        // //    if(root!=null&&root.val==targetSum&&(root.left!=null||root.right!=null)){
        // //        return false;
        // //    }
        //     myTargetSum = targetSum;
        //     return traverse(root, currentSum);

        // }
        // public boolean traverse(TreeNode root, int currentSum){
        //     if (root!=null){
        //         if(root.left==null&&root.right==null){
        //             if(currentSum==myTargetSum){
        //                 return true;
        //             }else{
        //                 return false;
        //             }
        //         }
        //     }else {
        //         //return false;
        //         currentSum+=root.val;
        //         return traverse(root.left, currentSum)|| traverse(root.right,currentSum);
        //     }
        //     return false;
        // }
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }
            if(root.left == null&&root.right==null){
                return root.val == targetSum;
            }
            return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
        }



    }
    static class Solution20240213 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null){
                return false;
            }
            //误将0写成了root.val。遇到不确定的情况可以用代入法
            return dfs(root,0,targetSum);
        }
        public boolean dfs(TreeNode root, int currentSum, int targetSum){
            if(root==null){
                return false;
            }
            System.out.println(root.val+currentSum+"#####"+targetSum);
            if(root.left==null&&root.right==null){
                if(root.val + currentSum == targetSum){
                    return true;
                }
            }
            return dfs(root.left,currentSum+root.val,targetSum) || dfs(root.right, currentSum+root.val, targetSum);
        }
    }
}