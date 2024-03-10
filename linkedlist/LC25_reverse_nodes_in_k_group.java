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
}