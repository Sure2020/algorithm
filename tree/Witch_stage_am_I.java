/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Witch_floor_am_I
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
public class Witch_stage_am_I {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);

        whereAmI(root,1);
    }
    public static void whereAmI(TreeNode root, int i){
        if (root == null){
            return;
        }
        System.out.print("I am on floor: " + i );
        System.out.println(  " my value is: " + root.val);
        whereAmI(root.left, i+1);
        whereAmI(root.right, i+1);
    }

}