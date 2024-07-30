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
    //双指针，哎心急了，忘了把双指针向前推进，要不然有又一道速通！
    public class Solution20240516 {
        public boolean hasCycle(ListNode head) {
            if(head==null|| head.next==null){
                return false;
            }
            ListNode slow=head, fast=head.next.next;
            while(fast!=null && fast.next!=null){
                if(slow==fast){
                    return true;
                }
                slow=slow.next;
                fast=fast.next.next;
            }
            return false;
        }
    }

    //双指针，一步两步，相等
    public class Solution20240524 {
        public boolean hasCycle(ListNode head) {
            if(head==null){
                return false;
            }
            ListNode slow=head,fast=head;

            // 这里错把且写成了或
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    return true;
                }
            }
            return false;
        }
    }

    public class Solution20240621 {
        public boolean hasCycle(ListNode head) {
            if(head==null || head.next==null){
                return false;
            }
            ListNode slow=head,fast=head.next.next;
            while(fast!=null&&fast.next!=null){
                if(slow==fast){
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }
//快慢指针，慢走1，快走2

    public class Solution20240730 {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head,slow=head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow){
                    return true;
                }
            }
            return false;
        }
    }
//快慢指针，快1慢2，判断相遇
//事后：我的妈，从开始敲到提交，可能都不到一分钟，一次过
}