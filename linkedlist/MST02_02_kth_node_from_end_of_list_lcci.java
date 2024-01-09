/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MST0202_kth_node_from_end_of_list_lcci
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
public class MST02_02_kth_node_from_end_of_list_lcci {
    public int kthToLast(ListNode head, int k) {
        if(head==null){
            return 0;
        }
        if(head.next==null&&k==1){
            return head.val;
        }
        ListNode fasterPoint = head,slowerPoint = head;
        while(k!=0){
            fasterPoint = fasterPoint.next;
            k--;
            if(fasterPoint==null && k!=0){
                return 0;
            }

        }
        while(fasterPoint!=null){
            fasterPoint = fasterPoint.next;
            slowerPoint = slowerPoint.next;
        }
        return slowerPoint.val;

    }
}