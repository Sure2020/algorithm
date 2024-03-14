/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC124_binary_tree_maximum_path_sum
 * Date Created : 2024-03-14
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-14       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-14
 **/
public class LC124_binary_tree_maximum_path_sum {
    //这题我纠结了好久，为什么要在0和当前结果直接取一下最大值，最后把一个只有两层的二叉树代入，就想通了，再最后，通过用例2，-1再次加深了理解。但这个细节估计后面自己还是想不到，所以要多练几次
    class Solution {
        int maxPath=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxPath;
        }
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = Math.max(dfs(root.left),0);
            int right = Math.max(dfs(root.right),0);
            // int left = dfs(root.left);
            // int right = dfs(root.right);
            int currentPath=root.val+left+right;
            maxPath=Math.max(currentPath, maxPath);
            return Math.max(left, right)+root.val;
        }

    }
}