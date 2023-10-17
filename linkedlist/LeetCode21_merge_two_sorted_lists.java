/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LeetCode21
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
public class LeetCode21_merge_two_sorted_lists {
    public static void main(String[] args) {
        /*LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.print();*/
        System.out.println("###case1###");
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4,null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4,null)));
        ListNode listNode = mergeTwoLists(list1, list2);
        ListNode current = listNode;
        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }


        System.out.println("###case2###");
        list1 = null;
        list2 = null;
        ListNode listNode2 = mergeTwoLists(list1, list2);
        ListNode current2 = listNode2;
        while(current2 != null) {
            System.out.println(current2.val);
            current2 = current2.next;
        }


        System.out.println("###case3###");
        list1 = null;
        list2 = new ListNode(0);
        ListNode listNode3 = mergeTwoLists(list1, list2);
        ListNode current3 = listNode3;
        while(current3 != null) {
            System.out.println(current3.val);
            current3 = current3.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode currentOfResult = result;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                currentOfResult.val = p1.val;
                p1=p1.next;
            } else {
                currentOfResult.val = p2.val;
                p2=p2.next;
            }

            ListNode newNode = new ListNode();
            currentOfResult.next = newNode;
            currentOfResult = currentOfResult.next;

        }
        if(p1!=null){
            currentOfResult.val = p1.val;
            currentOfResult.next = p1.next;
        }else if(p2!=null){
            currentOfResult.val = p2.val;
            currentOfResult.next = p2.next;
        } else {
            return null;
        }
        return result;
    }
}