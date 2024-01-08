/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR171_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof
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
public class LCR171_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA=headA,pointB = headB;
        // while(pointA!=null&&pointB!=null){
        //     if(pointA == pointB){
        //         return pointA;
        //     }
        //     if(pointA.next==null&&pointB.next==null){
        //         return null;
        //     }
        //     pointA = pointA.next;
        //     pointB = pointB.next;
        //     if(pointA ==null){
        //         pointA=headB;
        //     }
        //     if(pointB==null){
        //         pointB=headA;
        //     }
        // }
        // return null;
        while(pointA!=pointB){
            if(pointA!=null){
                pointA = pointA.next;
            }else{
                pointA =headB;
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