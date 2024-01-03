/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LinkedList
 * Date Created : 2023-10-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-16       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-16
 **/
public class MyLinkedList {
    ListNode head;
    public MyLinkedList(){
        head = null;
    }
    public void append(int val){
        ListNode newNode = new ListNode(val);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void print(){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }
}