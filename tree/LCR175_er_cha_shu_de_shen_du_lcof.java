/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LCR175_er_cha_shu_de_shen_du_lcof
 * Date Created : 2023-12-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-27       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-27
 **/
public class LCR175_er_cha_shu_de_shen_du_lcof {
    public static void main(String[] args) {
        TreeNode tempNode = new TreeNode();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        tempNode = root.right;
        tempNode.left = new TreeNode(15);
        tempNode.right = new TreeNode(7);

        //System.out.println(maxDepth(root));
        System.out.println(calculateDepth(root));

        System.out.println("case2");
        TreeNode tempNode2 = new TreeNode();
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        //System.out.println(maxDepth(root2));
        System.out.println(calculateDepth(root2));
    }
    public static int calculateDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = calculateDepth(root.left);
        int right = calculateDepth(root.right);
        return Math.max(left, right)+1;
    }
}
