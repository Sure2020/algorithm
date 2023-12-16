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

import java.util.ArrayList;
import java.util.List;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-18
 **/
public class Tools {
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
}