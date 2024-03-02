/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC141_linked_list_cycle
 * Date Created : 2024-01-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-05       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2024-01-05
 **/
public class LC141_linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null){
            return false;
        }
        ListNode fasterPoint = head, slowerPoint = head;
        while(slowerPoint.next !=null){
            slowerPoint = slowerPoint.next;
            fasterPoint = fasterPoint.next;
            if(fasterPoint ==null ||fasterPoint.next==null){
                return false;
            }
            fasterPoint = fasterPoint.next;
            if(slowerPoint == fasterPoint){
                return true;
            }
        }
        return false;
    }
    //再次做，竟然用不到一分钟的时候一次性通过，而且比原先写得更精简，不愧是我！
    public class Solution20240302 {
        public boolean hasCycle(ListNode head) {
            if(head==null||head.next==null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast!=null&&fast.next!=null){
                if(slow!=fast){
                    slow=slow.next;
                    fast=fast.next.next;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
}