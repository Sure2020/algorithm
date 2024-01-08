/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR142_he_bing_liang_ge_pai_xu_de_lian_biao_lcof
 * Date Created : 2024-01-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-08
 **/
public class LCR142_he_bing_liang_ge_pai_xu_de_lian_biao_lcof {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode point1 = l1, point2 = l2, pointNew = dummy;
        while (point1 != null && point2 != null) {
            if (point1.val <= point2.val) {
                pointNew.next = point1;
                point1 = point1.next;
            } else {
                pointNew.next = point2;
                point2 = point2.next;
            }
            pointNew = pointNew.next;
        }
        if (point1 != null) {
            pointNew.next = point1;
        }
        if (point2 != null) {
            pointNew.next = point2;
        }
        return dummy.next;
    }
}