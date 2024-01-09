/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MST02_07_intersection_of_two_linked_lists_lcci
 * Date Created : 2024-01-09
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-09       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-09
 **/
public class MST02_07_intersection_of_two_linked_lists_lcci {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pointA = headA, pointB = headB;
        while(pointA != pointB){
            if(pointA!=null){
                pointA=pointA.next;
            }else{
                pointA = headB;
            }
            if(pointB!=null){
                pointB = pointB.next;
            }else{
                pointB = headA;
            }
        }
        return pointA;
    }
}