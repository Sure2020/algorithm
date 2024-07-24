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


    //先理思路：翻转整个链表相当于翻转从Head到null之间的链表，稍作修改就能写出翻转从head到p节点之间节点的方法
    //然后不断调用reverseBetween打到最终效果
    class Solution202405161544 {
        public ListNode reverseKGroup(ListNode head, int k) {
            //base case
            ListNode p = head;
            for(int i=0;i<k;i++){
                if(p==null){
                    return head;
                }
                p=p.next;
            }
            ListNode newHead = reverseBetween(head, p);
            head.next = reverseKGroup(p, k);
            return newHead;
        }
        public ListNode reverseBetween(ListNode head, ListNode p){
            ListNode previous=null, current=head, next=null;
            while(current!=p){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }


    //先理清思路：写出翻转两个节点之间的链表的函数
    //还算厉害，地铁早班20分钟左右独立写出，调了两三次就AC，逐渐掌握了一个调试技巧就是有辅助函数的情况下，可以先只调用辅助函数来调试，先保证辅助函数没问题
    class Solution20240524 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode p = head;
            for(int i=1;i<=k;i++){
                //base case
                if(p==null){
                    return head;
                }
                p=p.next;
            }

            ListNode newHead = reverseBetween(head, p);
            head.next=reverseKGroup(p,k);
            return newHead;
            //return reverseBetween(head, head.next.next);

        }
        //区间[a,b)
        //这里要用迭代，更方便控制节点区间
        public ListNode reverseBetween(ListNode a, ListNode b){
            // ListNode dummy = new ListNode();
            ListNode previous=null,current=a,next=null;
            // 哈哈我踏马真是做一次就在这里踩坑一次，如果翻转整个链表，结束条件才是!=null，现在是翻转区间，就要!=b
            while(current!=b){
                //这里的四步一画图就了然
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution20240619 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode p = head;
            for(int i=1;i<=k;i++){
                //不够k个一组，不翻转直接返回
                if(p==null){
                    return head;
                }
                p = p.next;
            }
            //System.out.println(p.val);
            ListNode newHead = reverse(head, p);
            head.next = reverseKGroup(p, k);
            return newHead;
            //return reverse(head, null);
        }
        //记住迭代方式的翻转链表，是节点两个两个地翻转，不要一次想翻转3个节点
        public ListNode reverse(ListNode n1, ListNode n2){
            ListNode previous=null,current=n1,next=n1;
            while(current!=n2){
                next = current.next;
                current.next=previous;
                previous = current;
                current = next;
            }
            //最后return谁，记一下，或者用例子推演一下
            return previous;
        }
    }
//先前进k个节点，然后记录第k个节点后面那个节点successor，再翻转1-k个节点，再将successor节点与之拼接
//稀里糊涂调了很久，都是小细节，再练练吧。


    class Solution20240724 {
        public ListNode reverseKGroup(ListNode head, int k) {
            // return reverse(head, null);
            if(head==null || head.next==null){
                return head;
            }
            ListNode p = head;
            for(int i=1;i<=k;i++){
                if(p==null){
                    // 原来是这里，没有将其返回导致不该翻转的部分也翻转了。但！这顺便解决了“不足k个也翻转”的问题！
                    // break;
                    return head;
                }
                p=p.next;
            }
            ListNode newHead = reverse(head, p);
            // if(p==null){
            //     return newHead;
            // }
            head.next = reverseKGroup(p,k);
            return newHead;
        }
        public ListNode reverse(ListNode node1, ListNode node2){
            ListNode previous=null, current = node1,next=null;
            //这里又差点踩坑，边界是node2而不是null
            while(current!=node2){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }
//需要利用迭代式的翻转链表函数
}