/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC25_reverse_nodes_in_k_group
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
 * 这个考察的知识点挺全面的，而且难度为困难，值得多练，目前还无法独立写出来
 * @author: Admin
 * @create: 2024-03-10
 **/
public class LC25_reverse_nodes_in_k_group {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null){
                return null;
            }
            ListNode a=head,b=head;
            for(int i=0;i<k;i++){
                if(b==null){
                    return head;
                }
                b=b.next;
            }
            ListNode newHead = reverse(a,b);
            a.next=reverseKGroup(b,k);
            return newHead;
        }
        public ListNode reverse(ListNode a, ListNode b){
            // 这里不能加这个，也就是允许a 或 b 为null（应该是b可以为null吧）
            // if(a==null || b==null){
            //     return null;
            // }
            ListNode pre=null, cur=a, nxt=a;
            while(cur!=b){
                nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            return pre;
        }
    }

    class Solution20240515 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null){
                return null;
            }
            ListNode a=head,b=head;
            for(int i=0;i<k;i++){
                if(b==null){
                    return head;
                }
                b=b.next;
            }
            //注意1，忘了把reverse用上
            ListNode newHead = reverse(a,b);
            a.next=reverseKGroup(b,k);
            return newHead;
        }
        //[a,b)
        public ListNode reverse(ListNode a, ListNode b){
            ListNode previous=null,current=a,next=null;
            //注意2，这里是将区间[a,b)翻转，所以结束条件是current!=b，而不是current!=null!
            while(current!=b){
                next = current.next;
                current.next=previous;
                previous=current;
                current=next;
            }
            return previous;
        }
    }

    class Solution20240516 {
        public ListNode reverseKGroup(ListNode head, int k) {
            // if(head==null || head.next==null){
            //     return head;
            // }
            ListNode p=head;
            //base case不足k个，原样返回

            for(int i=0;i<k;i++){
                if(p==null){
                    return head;
                }
                p=p.next;
            }
            //此时[head,p)区间内有k个待翻转的元素

            ListNode newHead = reverseBetween(head, p);
            // 注意2，这里写成了reverseKGroup(p.next,k)，显然是没搞清楚区间，记住区间是[head,p)
            head.next = reverseKGroup(p, k);
            return newHead;


        }
        public ListNode reverseBetween(ListNode a, ListNode b){
            ListNode previous=null, current=a,next=null;
            //注意1，这里，又双写成了current!=null，又双是思维定式，应该是current!=b，因为现在的右边界是b呀
            while(current!=b){
                next = current.next;
                current.next=previous;
                previous=current;
                current=next;
            }
            return previous;
        }
    }
}