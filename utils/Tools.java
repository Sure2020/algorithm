/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Tools
 * Date Created : 2023-10-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-18       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-18
 **/
public class Tools {
    public static void main(String[] args) {
        TreeNode root = treeCreater(new int[] {1,2,3,-1,5,-1,4});
        treePrinterPreorder(root);
    }
    public static ListNode listNodeCreater(int[] sourceList) {
        if (sourceList == null || sourceList.length == 0) {
            return null;
        }
        /*if (sourceList.length == 0){
            return new ListNode(0);
        }*/
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int i : sourceList) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dummy.next;
    }

    public static void listNodePrinter(ListNode listNode) {
        ListNode head = listNode;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void listPriter(int[] nums){
        for (int val: nums ) {
            System.out.println(val);
        }
    }
    public static void listPriter(char[] s){
        for (char c: s ) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void listPriter(List<Integer> list){
        for (Integer i: list ) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static TreeNode treeCreater(int[] source){
        return treeCreaterRecursor(source, 0);
    }
    private static TreeNode treeCreaterRecursor(int[] source, int index){
        if(index>=source.length||source[index]==-1){
            return null;
        }
        TreeNode root = new TreeNode(source[index]);
        root.left = treeCreaterRecursor(source, 2*index+1);
        root.right = treeCreaterRecursor(source, 2*index+2);

        return root;
    }

    public static void treePrinterPreorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        treePrinterPreorder(root.left);
        treePrinterPreorder(root.right);
    }

    public static void treePrettyPrinter(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null)
            return;

        printTree(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + node.val);
        } else {
            System.out.println(node.val);
        }
        printTree(node.left, level + 1);
    }
}