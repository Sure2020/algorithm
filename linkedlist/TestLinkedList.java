/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestLinkedList
 * Date Created : 2023-10-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-15       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: 单向链表的初始化和遍历
 * @author: w15021
 * @create: 2023-10-15
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        System.out.println("testing");
        ListNode listNode = new ListNode(-1);
        ListNode head = listNode;
        System.out.println(listNode.val);

        for (int i=0;i<5;i++){
            ListNode tempListNode = new ListNode(i);
            head.next = tempListNode;
            head = head.next;
        }
        ListNode p = listNode;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}