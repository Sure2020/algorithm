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

    //分清内部最大值和返回给外层递归调用的最大值
//很明显是分解的思路
    class Solution20240604 {
        //f**k me! 竟然因为result的初始值写成了0，导致没过，还调试了几次！真是自己坑自己，还调试了好久！
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            // if(root.left==null && root.right==null){
            //     return root.val;
            // }
            maxPath(root);
            return result;
        }
        //函数定义，返回树从根节点到叶子节点的最长边吧
        public int maxPath(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = maxPath(root.left);
            int right = maxPath(root.right);
            int currentSum = left+right+root.val;
            //挑战一下最大值
            result = Math.max(result, currentSum);
            int innerMax = Math.max(left+root.val, right+root.val);
            return innerMax >0?innerMax:0;
        }
    }
    //肯定是分解的思路了
    //可以和LC543一起看，一模一样的思路
    class Solution20240607 {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result;
        }
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            //challenge max
            int innerMax = left + right + root.val;
            result = Math.max(result, innerMax);
            int outerMax = Math.max(left, right) + root.val;
            return outerMax>0?outerMax:0;
        }
    }

    class Solution20240701 {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            splict(root);
            return result;
        }
        public int splict(TreeNode root) {
            //System.out.println("##################");
            if(root==null){
                return -1;
            }
            int left = splict(root.left);
            int right = splict(root.right);
            //System.out.println(" root: "+ root.val + "  left: " + left + "  right:  " + right);
            int currentMax = root.val;
            if(left>0){
                currentMax += left;
            }
            if(right>0){
                currentMax += right;
            }
            //挑战一下最大值
            result = currentMax>result?currentMax:result;
            //System.out.println(" result: " + result + " currentMax: " + currentMax);
            //System.out.println("##################");
            //这里return的时候不能返回root+left+right，而要返回root+Max(left,right);
            int returnValue = root.val;
            if(left>0||right>0){
                returnValue += Math.max(left,right);
            }
            return returnValue;
        }
    }
//分解的递归。有一处我记得是返回0

    class Solution20250525 {
        // 这里，求最值时，尤其注意result的默认值，要取边界，不要随便等于0
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result;
        }
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            int left=dfs(root.left);
            int right = dfs(root.right);
            int innerMax = root.val+left+right;
            result = Math.max(result, innerMax);

            int outerMax = Math.max(left, right)+root.val;
            return outerMax>0?outerMax:0;
        }
    }
}