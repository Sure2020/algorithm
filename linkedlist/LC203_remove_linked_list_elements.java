/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC203_remove_linked_list_elements
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
public class LC203_remove_linked_list_elements {
    public static void main(String[] args) {
        ListNode list1 = Tools.listNodeCreater(new int[]{7, 7, 7, 7});
        Tools.listNodePrinter(removeElements(list1, 7));


    }
    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cursor = dummy;

        while(cursor!=null &&cursor.next!=null){
            if(cursor.next.val == val){
                cursor.next = cursor.next.next;
            } else{
                cursor = cursor.next;

            }

        }
        return dummy.next;

    }
}