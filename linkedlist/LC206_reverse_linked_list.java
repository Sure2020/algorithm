/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC206_reverse_linked_list
 * Date Created : 2024-01-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-05       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 再次写，依稀对head.next.next=head有印象，但仍无法独立写出来，需要巩固！
 * @author: Admin
 * @create: 2024-01-05
 **/
public class LC206_reverse_linked_list {
    public static void main(String[] args) {
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5});
        Tools.listNodePrinter(reverseList(list1));
    }
    static ListNode dummy = new ListNode();
    static ListNode cursorPoint = dummy;
    public static ListNode reverseList(ListNode head) {
        reverse(head);
        return dummy.next;

    }
    public static void reverse(ListNode head){
        if(head==null){
            return;
        }else{

            reverse(head.next);
            ListNode tempNode = new ListNode(head.val);
            cursorPoint.next = tempNode;
            cursorPoint = cursorPoint.next;
        }

    }
    class Solution20240302 {
        public ListNode reverseList(ListNode head) {
            //这里忘了写head.next的情况，造成空指针异常
            if(head==null ||head.next==null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return last;
        }
    }
    class Solution20240304 {
        public ListNode reverseList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next=null;
            return last;
        }
    }
    class Solution20240309 {
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next ==null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next =null;
            return last;
        }
    }

    //看了labuladong的迭代解释，然后自己“独立”写出，迭代的空间复杂度为o(1)，还是值得记忆的
    class Solution20240309Iterative {
        public ListNode reverseList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode previous=null,current=head,next=head;
            while(current!=null){
                next=current.next;
                current.next=previous;
                previous=current;
                current=next;
            }
            return previous;
        }
    }
    class Solution20240514 {
        public ListNode reverseList(ListNode head) {
            return reverse(head);
        }
        //定义函数：返回翻转后的链表，返回的是尾部节点

        ListNode reverse(ListNode root){
            if(root==null || root.next ==null){
                return root;
            }
            // 注意！！！这个last，是head这个链表的尾部！我一开始一直认定它是链表头部，绕晕了！想好reverse函数的含义！那它的返回值也就明朗了！
            ListNode last = reverse(root.next);
            root.next.next = root;
            root.next=null;
            return last;
        }
    }
    class Solution20240515 {
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next == null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
    class Solution20240515IteraterSelf {
        public ListNode reverseList(ListNode head) {
            if(head==null ||head.next==null){
                return head;
            }
            ListNode p1 = null;
            ListNode p2 = head;
            while(p2.next!=null){
                ListNode temp = p2.next;
                p2.next=p1;
                p1=p2;
                p2=temp;
            }
            p2.next=p1;
            return p2;
        }
    }
    class Solution20240515Iterater {
        public ListNode reverseList(ListNode head) {

            ListNode previous = null;
            ListNode current = head;
            ListNode next = null;
            while(current!=null){
                next = current.next;
                current.next=previous;
                previous=current;
                current=next;
            }
            return previous;
        }
    }

    class Solution20240523 {
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    class Solution20240618 {
        //函数定义，返回翻转后的链表，返回原链表的尾部节点
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next=null;
            return last;
        }
    }
//我就记得一招head.next.next=head，让我直呼巧妙
    class Solution20240722 {
        //函数定义：返回翻转后的链表
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode result = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return result;
        }
    }
    //head.next.next = head?

    class Solution20240903 {
        public ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return newHead;
        }
    }

    class Solution20241115 {
        public ListNode reverseList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode previous = null,current=head,next=null;
            while(current!=null){
                next = current.next;
                current.next = previous;
                previous = current;
                current =next;
            }
            return previous;
        }
    }

    class Solution20241125 {
        public ListNode reverseList(ListNode head) {
            if(head==null|| head.next==null){
                return head;
            }
            ListNode pre = null,cur = head,next=null;
            while(cur!=null){
                next=cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    class Solution20241125_digui {
        public ListNode reverseList(ListNode head) {
            if(head==null|| head.next==null){
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}