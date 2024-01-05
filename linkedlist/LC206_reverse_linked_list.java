/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC206_reverse_linked_list
 * Date Created : 2024-01-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-05       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-05
 **/
public class LC206_reverse_linked_list {
    public static void main(String[] args) {
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5});
        Tools.listNodePrinter(reverseList(list1));
    }
    static ListNode dummy = new ListNode();
    static ListNode cursorPoint = dummy;
    public static ListNode reverseList(ListNode head) {
        reverse(head);
        return dummy.next;

    }
    public static void reverse(ListNode head){
        if(head==null){
            return;
        }else{

            reverse(head.next);
            ListNode tempNode = new ListNode(head.val);
            cursorPoint.next = tempNode;
            cursorPoint = cursorPoint.next;
        }

    }
}