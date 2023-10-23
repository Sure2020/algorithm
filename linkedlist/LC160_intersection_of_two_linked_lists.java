/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC160_intersection_of_two_linked_lists
 * Date Created : 2023-10-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-23       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-23
 **/
public class LC160_intersection_of_two_linked_lists {
    public static void main(String[] args) {
        System.out.println("case1");
        ListNode list1_1 = Tools.listNodeCreater(new int[]{4, 1, 8, 4, 5});
        ListNode list1_2 = Tools.listNodeCreater(new int[]{5, 6, 1});
        ListNode head1_1 = list1_1;
        ListNode head1_2 = list1_2;
        while (head1_1.val != 8) {
            head1_1 = head1_1.next;
        }
        while (head1_2.next != null) {
            head1_2 = head1_2.next;
        }
        head1_2.next = head1_1;

        //Tools.listNodePrinter(getIntersectionNode(list1_1, list1_2));
        System.out.println(getIntersectionNode_labuladong(list1_1, list1_2).val);

        System.out.println("case3");
        ListNode list3_1 = Tools.listNodeCreater(new int[]{2,6,4});
        ListNode list3_2 = Tools.listNodeCreater(new int[]{1,5});
        System.out.println(getIntersectionNode_labuladong(list3_1, list3_2).val);
    }
    public static ListNode getIntersectionNode_labuladong(ListNode headA, ListNode headB) {
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        while(currentNodeA != currentNodeB){
            if (currentNodeA == null){
                currentNodeA = headB;
            } else {
                currentNodeA = currentNodeA.next;
            }

            if (currentNodeB == null){
                currentNodeB = headA;
            } else {
                currentNodeB = currentNodeB.next;
            }
        }

        return currentNodeA;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentNodeA1 = headA;
        ListNode currentNodeA2 = headB;

        ListNode currentNodeB1 = headB;
        ListNode currentNodeB2 = headA;
        while(currentNodeA2 != currentNodeB2){
            if(currentNodeA1.next != null){
                currentNodeA1 = currentNodeA1.next;
            } else if (currentNodeA2.next != null){
                currentNodeA2 = currentNodeA2.next;
            } else {
                return null;
            }

            if(currentNodeB1.next != null){
                currentNodeB1 = currentNodeB1.next;
            } else if (currentNodeB2.next != null){
                currentNodeB2 = currentNodeB2.next;
            } else {
                return null;
            }

        }

        return currentNodeA2;
    }
}