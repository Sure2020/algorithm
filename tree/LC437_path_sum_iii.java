/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC437_path_sum_iii
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
 * 入参targetSum不能是Int,因为会溢出；待用前缀和再接一遍
 * @author: Admin
 * @create: 2024-02-13
 **/
public class LC437_path_sum_iii {
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{1000000000,1000000000,-1,294967296,-1,1000000000,-1,1000000000,-1,1000000000});
        root.left.left.left.left=new TreeNode(1000000000);
        root.left.left.left.left.left=new TreeNode(1000000000);
        Tools.treePrettyPrinter(root);
        Solution sol = new Solution();
        System.out.println(sol.pathSum(root,0));
    }
    static class Solution {
        int sum = 0;
        public int pathSum(TreeNode root, int targetSum) {
            if(root==null){
                return 0;
            }
            find(root, targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return sum;
        }
        // 入参targetSum不能是Int,因为会溢出
        public void find(TreeNode root, long targetSum){
            if(root==null){
                return;
            }
            if(root.val == targetSum){
                sum++;
            }
            find(root.left, targetSum-root.val);
            find(root.right, targetSum-root.val);
        }
    }
}