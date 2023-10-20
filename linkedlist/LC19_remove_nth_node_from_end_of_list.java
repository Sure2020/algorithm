/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC_remove_nth_node_from_end_of_list
 * Date Created : 2023-10-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-19       w15021     xxx
 * --------------------------------------------------------------------
 */

import javax.tools.Tool;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-19
 **/
public class LC19_remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5});
        Tools.listNodePrinter(removeNthFromEnd(list1, 5));

        System.out.println("case3");
        ListNode list3 = Tools.listNodeCreater(new int[]{1, 2});
        Tools.listNodePrinter(removeNthFromEnd(list3, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        ListNode fasterHead = dummy;
        ListNode slowerHead = dummy;

        for (int i=1;i<=n;i++){
            if (fasterHead != null){
                fasterHead = fasterHead.next;
            }
        }
        while (fasterHead.next!=null){
            fasterHead = fasterHead.next;
            slowerHead = slowerHead.next;
        }
        //System.out.println("current node val: " + slowerHead.val);
        /*ListNode tempNode = slowerHead.next;
        slowerHead.next = tempNode.next;*/
        slowerHead.next = slowerHead.next.next;
        return dummy.next;
    }
}