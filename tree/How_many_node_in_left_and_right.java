/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : How_many_node_left_right
 * Date Created : 2023-11-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-20       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-20
 **/
public class How_many_node_in_left_and_right {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);
        howMany(root);
    }
    public static int howMany(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = howMany(root.left);
        int right = howMany(root.right);
        System.out.printf("node %d 's left and right tree,node count: %d %d", root.val,left,right);
        System.out.println();
        return left+right+1;
    }
}