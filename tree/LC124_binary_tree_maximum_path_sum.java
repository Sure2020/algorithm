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
    public static void main(String[] args) {
        TreeNode root = Tools.treeCreater(new int[]{-10,9});
        TreeNode root2 = Tools.treeCreater(new int[]{20,15,7});
        root.right=root2;
        //Tools.treePrettyPrinter(root);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(-1);
        Tools.treePrettyPrinter(root3);
        Solution202406031919 solution202406031919 = new Solution202406031919();
        System.out.println(solution202406031919.maxPathSum(root3));
    }
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

    static class Solution202406031919 {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result;
        }
        public int dfs(TreeNode root){
            //null,贡献为0
            if(root==null){
                return 0;
            }
            //计算左右子树的贡献
            int left = dfs(root.left);
            int right = dfs(root.right);
            //内部最大路径和，就是根加上左右树的贡献
            int innerMax = left+right + root.val;
            //挑战一下最大值
            result = Math.max(result, innerMax);
            //将贡献返回给外层时，是从左右子树中选一条和较大的，再加上根
            int outMax = Math.max(left + root.val,right+root.val);
            //通过调试，我踏马悟了啊，问：这里为什么在小于0时要返回0，而不是直接返回outMax，
            //有人说：为了告诉根节点别走我这里了，我感觉这B没真正理解。让我解释的话，就是：
            //为了让贡献值为负的节点不影响整个路径的最大和。那怎么做到不影响呢，就在本层递归直接返回0，那在此次递归的外层，会加0，就相当于什么也没加，就相当于没影响到最大路径和了
            return outMax>0?outMax:0;
            //return outMax;
        }
    }
}