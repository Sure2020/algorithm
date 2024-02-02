/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : PreorderTraversalOfABinaryTree
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
public class PreorderInOrderPostOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        tempNode = root.right;
        tempNode.right = new TreeNode(3);

        tempNode = root.left;
        tempNode.left = new TreeNode(3);

        System.out.println("\n####  preorder");//12323
        preOrder(root);
        System.out.println("\n####  inorder");//32123
        inOrder(root);
        System.out.println("\n###   postorder");//32321
        postOrder(root);
    }
    public static void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if (root ==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
}