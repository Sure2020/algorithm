/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC110_balanced_binary_tree
 * Date Created : 2024-02-02
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-02       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-02
 **/
public class LC110_balanced_binary_tree {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        tempNode = root.right;
        tempNode.right = new TreeNode(3);

        tempNode = root.left;
        tempNode.left = new TreeNode(3);

        System.out.println(isBalanced(root));
        System.out.println(depthOfTree(root, 0));
    }
    static public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        /*int depthDifference =depthOfTree(root.left,0)-depthOfTree(root.right,0);
        return depthDifference>=-1 && depthDifference<=1;*/
        try{
            depthOfTree(root,0);
        }catch (Exception e){
            if (e.getMessage().equals("not")){
                return false;
            }
        }
        return true;

    }
    static public boolean isBanlanced2(TreeNode root){
        if(root==null){
            return true;
        }
        int leftDepth = depthOfTree(root,1);
        int rightDepth = depthOfTree(root,1);
        if (Math.abs(leftDepth-rightDepth)>=1){
            return false;
        }
        boolean leftIs = isBanlanced2(root.left);
        boolean rightIs = isBanlanced2(root.right);
        return leftIs&&rightIs;
    }
   static public int depthOfTree(TreeNode root, Integer depth) {
        if(root==null){
            return 0;
        }
        depth++;
        if(root.left==null&&root.right==null){
            return depth;
        }
        int leftDepth = depthOfTree(root.left, depth);
        int rightDepth = depthOfTree(root.right, depth);
        //int diff = leftDepth - rightDepth;
//        if (diff<-1||diff>1){
//            System.out.println("error");
//            throw new RuntimeException("not");
//        }
        return Math.max(leftDepth, rightDepth);
    }

    //牛，自己独立，一次通过地做出来，毕竟是简单的问题。
    //这个就是一直挂着没提交的那个文件，从历史解法看来自己是想复杂啦
    class Solution20240313 {
        boolean result = true;
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            // boolean isLeftBalanced = isBalanced(root.left);
            // boolean isRightBalanced = isBalanced(root.right);
            depth(root);
            return result;

        }
        public int depth(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            if(Math.abs(leftDepth-rightDepth) > 1){
                result = false;
            }
            return Math.max(leftDepth, rightDepth)+1;
        }
    }
}