/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC876_middle_of_the_linked_list
 * Date Created : 2023-10-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-21       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-21
 **/
public class LC876_middle_of_the_linked_list {
    public static void main(String[] args) {
        System.out.println("case1");
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5});
        Tools.listNodePrinter(middleNode(list1));

        System.out.println("case2");
        ListNode list2 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5, 6});
        Tools.listNodePrinter(middleNode(list2));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fasterPoint = head;
        ListNode slowerPoint = head;
        while (fasterPoint != null && fasterPoint.next != null) {
            slowerPoint = slowerPoint.next;
            fasterPoint = fasterPoint.next.next;
        }
        return slowerPoint;
    }
}