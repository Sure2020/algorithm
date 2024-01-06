/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR023_intersection_of_two_linked_lists
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
 * @description: same to LC160
 * @author: Admin
 * @create: 2024-01-06
 **/
public class LCR023_intersection_of_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pointA1=headA,pointA2=headB,pointB1=headB,pointB2=headA;
        while(true){
            ListNode tempNodeA, tempNodeB;
            if(pointA1!=null){
                tempNodeA = pointA1;
                pointA1 = pointA1.next;
            }else if(pointA2!=null){
                tempNodeA = pointA2;
                pointA2 = pointA2.next;
            }else{
                return null;
            }

            if(pointB1!=null){
                tempNodeB = pointB1;
                pointB1 = pointB1.next;
            }else if(pointB2!=null){
                tempNodeB = pointB2;
                pointB2 = pointB2.next;
            }else{
                return null;
            }
            if(tempNodeA == tempNodeB){
                return tempNodeA;
            }
        }
    }
}