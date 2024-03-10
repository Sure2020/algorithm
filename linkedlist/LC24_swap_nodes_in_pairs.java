/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC24_swap_nodes_in_pairs
 * Date Created : 2024-03-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-10       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 没考虑太多，直接用k个一组翻转链表的方法解决了，而且是独立写出来的哦！
 * @author: Admin
 * @create: 2024-03-10
 **/
public class LC24_swap_nodes_in_pairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            return reverseK(head, 2);
        }
        public ListNode reverseK(ListNode head, int k){
            if(head==null||head.next==null){
                return head;
            }
            ListNode a=head,b=head;
            for(int i=0;i<k;i++){
                if(b==null){
                    return head;
                }
                b=b.next;
            }
            ListNode newHead = reverse(a,b);
            a.next = reverseK(b,k);
            return newHead;
        }
        public ListNode reverse(ListNode a, ListNode b){

            ListNode pre=null,cur=a,nxt=a;
            while(cur!=b){
                nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            return pre;
        }
    }
}