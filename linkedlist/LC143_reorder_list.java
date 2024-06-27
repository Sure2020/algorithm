/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC143_reorder_list
 * Date Created : 2024-03-04
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-04       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.Stack;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这题我觉得应该归为困难，太乱了而且细节超多，而且手工调试无法发现问题，唯有ide调试才能发现问题，难！记一下吧！或者干脆跳过！！！因为细节太多，再写很可能会写错，而且手工无法调试！
 * 或者，用转存到数组再遍历的方法！！！
 * 这题弄到最后都给我整不耐烦了。。。。。
 * @author: Admin
 * @create: 2024-03-04
 **/
public class LC143_reorder_list {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = Tools.listNodeCreater(new int[]{1,2,3,4});
        //Tools.listNodePrinter(head);
        solution.reorderList(head);
        Tools.listNodePrinter(head);

    }
    static class Solution {
        public void reorderList(ListNode head) {
            if(head==null||head.next==null){
                return;
            }
            ListNode midNode = middleNode(head);
            //2.这里有讲究，这里故意返回的是中点的前一个节点，为了是能将前后两部分断开（midNode.next=null;）
            ListNode rightPart = reverseList(midNode.next);
            midNode.next=null;
            ListNode left=head,right=rightPart;

            while(right!=null){
                ListNode tempNode1 = left.next;
                ListNode tempNode2 = right.next;
                left.next = right;
                //3.这个left=tempNode1;的位置有讲究，需要放这里，不能放下面
                left=tempNode1;

                right.next=left;
                //left=tempNode1;
                right=tempNode2;
            }
        }
        public void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
        public ListNode middleNode(ListNode head) {
            if(head==null){
                return null;
            }
            ListNode slow=head, fast=head;
            //1.这里有讲究，独立的求中点的题，是fast!=null&&fast.next!=null，这里特意向下走了一个，可以返回中点的前一个节点
            while(fast.next!=null&&fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
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

    static class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverseList(l2);
            mergeList(l1, l2);
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        public void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
    }


    //用了思路最简单的方法，虽然比较耗时，但时间复杂度低的算法太难，时间紧迫先这样
    class Solution20240520 {
        public void reorderList(ListNode head) {
            if(head==null || head.next==null){
                return;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while(p!=null){
                stack.push(p);
                p=p.next;
            }
            // ListNode newHead=head;
            ListNode left=head,right=null;
            // 这个while 条件值得记忆，分别对于链表偶数和奇数个的情况
            while(left.next!=right ||left.next.next!=right){
                right = stack.pop();
                right.next = left.next;
                left.next = right;
                left = right.next;
            }
            left.next=null;
        }
    }

    //思路：用一个栈存储节点，并依次取出拼接
    //早班折腾，晚班快到站时，无意间把left.next放到了while外面，竟然可以了。。。就这样解吧，毕竟纯独立搞定的
    class Solution20240527 {
        public void reorderList(ListNode head) {
            if(head==null || head.next==null){
                return;
            }
            ListNode p = head;
            Stack<ListNode> stack = new Stack<>();
            while(p!=null){
                stack.push(p);
                //忘了移动指针，导致超出内存限制。。。。
                p=p.next;
            }
            ListNode left = head,right=null;
            while(left!=null){
                right=stack.pop();
                // System.out.println(right.val);
                // System.out.println(left.val);
                // System.out.println("#####");
                right.next=left.next;
                //left.next.next=null;
                left.next=right;
                // left=left.next;
                left=right.next;

                if(left==null ||left==right || left.next==right){
                    break;
                }

            }
            //这是关键的一步，最后断开和后面的连接，否则会形成环
            left.next=null;
            return;
        }
    }

    //双指针，利用栈暂存
    class Solution20240528 {
        public void reorderList(ListNode head) {
            if(head==null || head.next==null || head.next.next==null){
                return;
            }
            ListNode p = head;
            Stack<ListNode> stack = new Stack<>();

            while(p!=null){
                stack.push(p);
                p=p.next;
            }
            ListNode left=head,right=null;
            while(left.next!=right || left.next.next!=right){
                right = stack.pop();
                right.next=left.next;
                left.next=right;
                left=right.next;
            }
            left.next=null;
        }
    }

    class Solution20240627 {
        public void reorderList(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            while(p!=null){
                stack.push(p);
                p=p.next;
            }
            ListNode p1 = head;
            ListNode p2 = null;
            while(p1!=p2 && p1.next!=p2){
                p2 = stack.pop();
                // 这一步是关键，竟然没想到
                p2.next = p1.next;
                // System.out.println("p2: " + p2.val);
                // System.out.println("p1: " + p1.val);
                p1.next = p2;
                p1 = p2.next;
            }
            p1.next=null;
        }
    }
//双指针，我想到了，用栈缓存，没想到
}