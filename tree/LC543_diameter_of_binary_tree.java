/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC543_diameter_of_binary_tree
 * Date Created : 2023-11-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-15       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-15
 **/
public class LC543_diameter_of_binary_tree {
    private static int maxLength = 0;

    public static void main(String[] args) {

        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        tempNode = root.left;
        tempNode.left = new TreeNode(4);
        tempNode.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //maxPathLength(root);
        maxDepth2(root);
        return maxLength;
    }

    public static void maxPathLength(TreeNode root) {
        if (root == null) {
            return ;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxLength = Math.max(left + right, maxLength);
        maxPathLength(root.left);
        maxPathLength(root.right);
    }


    static int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
    static int maxDepth2(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        maxLength = Math.max(left + right, maxLength);
        return Math.max(left, right)+1;
    }

    //不错不错，自己又一次短时间独立、一次修改后通过。不过速度为1ms，比不上第一次提交的0ms，把第一次0ms的写法重新提交，也是1ms，应该是leetcode系统有变化导致的，不用纠结
    class Solution20240313 {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            depth(root);
            return max;

        }

        public int depth(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftDepth = depth(root.left);
            int rightDepth=depth(root.right);
            max = Math.max(leftDepth+rightDepth, max);
            return Math.max(leftDepth, rightDepth)+1;
        }
    }

    //分解的思路
    class Solution20240604 {
        int result = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result;
        }
        //函数定义：返回通过根的左右子树的边之和
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            //System.out.println(left+"###"+right);
            //这里确实不应该+1，算的是边，不是节点
            result = Math.max(result,left+right);
            //return left+right+1;
            return Math.max(left,right)+1;
        }
    }

    //分解的思路
    //可以和LC124一起看，一模一样的思路
    class Solution20240607 {
        int result = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            //求的是节点的数目，减1，则是边的数目
            return result-1;
        }
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            //chanlenge
            result = Math.max(result, left+right+1);
            return Math.max(left,right)+1;
        }
    }

    class Solution20240711 {
        int result = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            dfs(root);
            return result-1;
        }
        public int dfs(TreeNode root){
            if(root==null){
                return 0;
            }
            //System.out.println("          root: " + root.val);
            //太蠢了，又是由于复制粘贴的原因，这里递归调用的方法写成了主函数diameterOfBinaryTree
            int left = dfs(root.left);
            //System.out.println("left: " + left);
            int right = dfs(root.right);
            //System.out.println("right: " + right);
            result = Math.max(left+right+1, result);
            return Math.max(left, right)+1;
        }
    }
//分解的思路，有个内部最大值和外部最大值

    class Solution20240803 {
        int result = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            max(root,1);
            return result;
        }
        //函数定义，返回左子树和右子树中较深的那个深度
        //在得到left和right后，根据题意进行差异化计算
        public int max(TreeNode root, int currentMax){
            if(root==null){
                return 0;
            }
            if(root.left==null && root.right==null){
                return 1;
            }
            int left = max(root.left, currentMax+1);
            int right = max(root.right, currentMax+1);
            //System.out.println("root: "+root.val+" left: "+left + " right: "+right);
            result = Math.max(result, (left+right));
            return Math.max(left,right)+1;
        }
    }
//分解的思路，和用分解的思路求二叉树的高度差不多的思路，只是在left和right的处理上有点区别
//在利用left和right进行差异计算时，想清楚要求什么

    class Solution20241128 {
        int result = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            depth(root);
            return result;
        }
        public int depth(TreeNode root){
            if(root==null){
                return 0;
            }
            // if(root.left==null && root.right==null){
            //     return 1;
            // }
            int left = depth(root.left);
            int right = depth(root.right);
            result = Math.max(result, (left+right));
            return Math.max(left,right)+1;
        }
    }
//分解的思路，和用分解的思路求二叉树的高度差不多的思路，只是在left和right的处理上有点区别
//在利用left和right进行差异计算时，想清楚要求什么
}