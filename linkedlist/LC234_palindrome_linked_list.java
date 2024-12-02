/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC234_palindrome_linked_list
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

import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 1.第三次看这题，才意识到递归这个思路是从labuladong那里学来的，第二次看提交记录我以为是自己的思路。。。
 * 2.空间复杂度O(1)的解法，看了labuladong的题解，自己写了一遍
 * @author: Admin
 * @create: 2024-01-05
 **/
public class LC234_palindrome_linked_list {
    public static void main(String[] args) {
        ListNode head = Tools.listNodeCreater(new int[]{1,2,2,1});
        System.out.println(isPalindrome(head));
    }
    static ListNode curser = new ListNode();
    static public boolean isPalindrome(ListNode head) {
        curser = head;
        return recurse(head);

    }
    static public boolean recurse(ListNode head){
        if(head==null){
            return false;
        }
        recurse(head.next);
        if(head.val != curser.val){
            return false;
        }

        curser = curser.next;
        if(curser==null){
            return true;
        }
        return false;

    }
    class Solution20240310 {
        public boolean isPalindrome(ListNode head) {
            if(head==null){
                return false;
            }
            //找到链表中点
            ListNode slow=head,fast=head;
            while(fast!=null &&fast.next!=null){
                slow=slow.next;
                fast = fast.next.next;
            }
            //从中点开始，翻转链表后半部分
            ListNode p1=head, p2=reverse(slow);
            //开始比对，判断
            while(p1!=null&&p2!=null){
                if(p1.val!=p2.val){
                    return false;
                }
                p1=p1.next;
                p2=p2.next;
            }
            return true;
        }
        public ListNode reverse(ListNode head){
            if(head==null || head.next==null){
                return head;
            }
            ListNode pre=null,cur=head,nxt=head;
            while(cur!=null){
                nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            return pre;
        }
    }
    class Solution20241202 {
        public boolean isPalindrome(ListNode head) {
            if(head==null){
                return false;
            }
            Stack<Integer> stack = new Stack<>();
            ListNode p1=head;
            while(p1!=null){
                //System.out.println("val: " + p1.val);
                stack.push(p1.val);
                p1=p1.next;
            }
            ListNode p2 = head;
            while(p2!=null){
                Integer currentPop = stack.pop();
                //System.out.println("pop: " + currentPop);
                //System.out.println("p2val: " + p2.val);
                if(!currentPop.equals(p2.val)){
                    return false;
                }
                //忘了向前推进指针。。。
                p2 = p2.next;
            }
            return true;
        }
    }
    class Solution20241202_reverse {
        public boolean isPalindrome(ListNode head) {
            if(head==null){
                return false;
            }
            ListNode fast = head,slow = head;
            while(fast!=null&& fast.next!=null){
                slow=slow.next;
                fast = fast.next.next;
            }
            ListNode half = reverse(slow);
            ListNode p1 = head, p2 = half;
            while(p1!=null && p2!=null){
                if(p1.val!=p2.val){
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }
        public ListNode reverse (ListNode head){
            if(head==null || head.next==null){
                return head;
            }
            ListNode previous=null,current = head,next=null;
            while(current!=null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
    }
//找到链表中点，反转中点后面的部分，对比前后两部分
//事后：根据思路框框写，最后一次通过，一些边界细节就是按直觉来的
}