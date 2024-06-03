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
        int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxPath;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(dfs(root.left), 0);
            int right = Math.max(dfs(root.right), 0);
            // int left = dfs(root.left);
            // int right = dfs(root.right);
            int currentPath = root.val + left + right;
            maxPath = Math.max(currentPath, maxPath);
            return Math.max(left, right) + root.val;
        }

    }

    //分解的思路：左右子树的最大路径和加上当前root节点的值
    class Solution20240603 {
        int result = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            maxPath(root);
            return result;
        }

        public int maxPath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //跟0比较，就是为了去掉为负数的和，有点贪心算法的意思，我最终为了路径和最大，你是负数，不利于我实现目标，我就丢掉
            //递归时，错将函数maxPath写成了maxPathSum
            int left = Math.max(0, maxPath(root.left));
            int right = Math.max(0, maxPath(root.right));
            //顺便更新最大值
            result = Math.max(result, left + right + root.val);
            //我领悟到了，说是贪心，只要大于零的值，但这里无法保证root.val的值大于零，其实这里返回一个负值也无所谓，因为
            //在上面的32，33行，会将值与0做比较。
            return Math.max(left, right) + root.val;
        }
    }
}