/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC86_partition_list
 * Date Created : 2023-10-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-17       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-17
 **/
public class LC86_partition_list {
    public static void main(String[] args) {
        System.out.println("##case1##"); //out [1,2,2,4,3,5]
        int[] intList1 = {1,4,3,2,5,2};
        ListNode sourceList1 = Tools.listNodeCreater(intList1);
        Tools.listNodePrinter(partition(sourceList1, 3));

        System.out.println("##case2##");//out [1,2]
        int[] intList2 = {2,1};
        ListNode sourceList2 = Tools.listNodeCreater(intList2);
        Tools.listNodePrinter(partition(sourceList2, 2));

    }
    public static ListNode partition(ListNode head, int x){

        ListNode result = new ListNode(-999);
        ListNode smallerPart = new ListNode(-888);
        ListNode biggerPart = new ListNode(-777);

        ListNode headPoint = head;
        ListNode smallerPartPoint = smallerPart;
        ListNode biggerPartPoint = biggerPart;
        int tempX;

        while(headPoint != null){
            tempX = headPoint.val;
            ListNode tempNode = new ListNode(tempX);
            if (tempX < x){
                smallerPartPoint.next = tempNode;
                smallerPartPoint = smallerPartPoint.next;
            } else {
                biggerPartPoint.next = tempNode;
                biggerPartPoint = biggerPartPoint.next;
            }
            headPoint = headPoint.next;
        }
        smallerPartPoint.next = biggerPart.next;
        result.next = smallerPart.next;
        return result.next;
    }
}