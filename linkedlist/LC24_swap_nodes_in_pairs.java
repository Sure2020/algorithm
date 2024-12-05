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

    //恍然大悟，原来这就是k个一组翻转链表的简化版，k为2
    class Solution20240516 {
        public ListNode swapPairs(ListNode head) {
            return reverseKGroup(head, 2);
        }
        public ListNode reverseKGroup(ListNode head, int k){
            ListNode p = head;
            for(int i=0;i<k;i++){
                if(p==null){
                    return head;
                }
                p=p.next;
            }
            //根据函数定义，先翻转前k个，翻转后，newHead为头，head为尾
            ListNode newHead = reverseBetween(head, p);
            //将尾部跟后面的接起来
            head.next = reverseKGroup(p, k);
            return newHead;
        }
        public ListNode reverseBetween(ListNode a, ListNode b){
            ListNode previous=null, current=a, next=null;
            while(current!=b){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }

    //轻松搞定
    class Solution20240524 {
        public ListNode swapPairs(ListNode head) {
            return reverseKgroup(head, 2);
        }
        public ListNode reverseKgroup(ListNode head, int k){
            if(head==null || head.next==null){
                return head;
            }
            ListNode p = head;
            for(int i=1;i<=k;i++){
                if(p==null){
                    return head;
                }
                p=p.next;
            }
            ListNode newHead = reverseBetween(head,p);
            head.next=reverseKgroup(p,k);
            return newHead;
        }
        public ListNode reverseBetween(ListNode a, ListNode b){
            ListNode previous=null,current=a,next=null;
            while(current!=b){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }

    class Solution20240718 {
        public ListNode swapPairs(ListNode head) {
            if(head==null){
                return null;
            }
            return swapK(head, 2);
            // ListNode p = head;
            // for(int i=1;i<=2;i++){
            //     p = p.next;
            //     if(p==null){
            //         return head;
            //     }
            // }
            // System.out.println("p: " + p.val);
            // return swap(head, p);

        }
        public ListNode swapK(ListNode head, int k){
            if(head==null){
                return null;
            }
            ListNode p = head;
            //System.out.println("p.val: " + p.val);
            for(int i=1;i<k;i++){
                p = p.next;
                //不足k个一组，则不用翻转直接返回
                if(p==null){
                    return head;
                }
            }
            //System.out.println("p: " + p.val);
            //System.out.println("p.next: " + p.next.val);
            // 注意，在swap之前，p.next和swap之后的p.next，指向不同，所以要在swap之前，先暂存p的指向！
            ListNode pNext = p.next;
            //System.out.println("pNext: " + pNext.val);
            ListNode newHead = swap(head, p);
            // System.out.println("p.next: " + p.next.val);
            head.next = swapK(pNext, k);
            return newHead;
            //return swapK(pNext,k);
        }
        public ListNode swap(ListNode node1, ListNode node2){
            ListNode previous = null,current = node1, next=null;
            while(previous!=node2){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }
//先写k个一组交换，再把k置为2
//需要利用迭代的方式交换两个节点间的节点
//走k步，再交换（head, head-->k）
//注意，在swap之前，p.next和swap之后的p.next，指向不同，所以要在swap之前，先暂存p的指向！
    class Solution20241205 {
        public ListNode swapPairs(ListNode head) {
            //这里自作聪明了，以为只有两个节点时，不用反转，其实2个节点应该反转！
            if(head==null || head.next==null /*|| head.next.next==null*/){
                return head;
            }
            ListNode a = head,b=head;;
            for(int i=1;i<=2;i++){
                if(b==null){
                    return head;
                }
                b = b.next;
            }
            ListNode newHead = reverse(a,b);
            a.next = swapPairs(b);
            return newHead;
        }
        public ListNode reverse(ListNode a, ListNode b){
            if(a==null || a.next==null){
                return a;
            }
            ListNode previous=null,current=a,next=null;
            while(current!=b){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }

    //先写k个一组交换，再把k置为2
    //需要利用迭代的方式交换两个节点间的节点
    //走k步，再交换（head, head-->k）
}