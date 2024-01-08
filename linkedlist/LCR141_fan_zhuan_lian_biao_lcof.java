/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR141_fan_zhuan_lian_biao_lcof
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
public class LCR141_fan_zhuan_lian_biao_lcof {
    public ListNode trainningPlan(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode last = trainningPlan(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}