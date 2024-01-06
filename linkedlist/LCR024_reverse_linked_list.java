/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR024_reverse_linked_list
 * Date Created : 2024-01-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-06
 **/
public class LCR024_reverse_linked_list {
    public static void main(String[] args) {
        ListNode sourceList1 = Tools.listNodeCreater(new int[]{1,2,3,4,5});
        Tools.listNodePrinter(reverseList_iterate(sourceList1));
    }
    public static ListNode reverseList_recurs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList_recurs(head.next);
        head.next.next = head;
        head.next = null;
        return result;

    }
    public static ListNode reverseList_iterate(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode previous = null,current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}