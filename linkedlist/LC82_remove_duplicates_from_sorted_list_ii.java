/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC82_remove_duplicates_from_sorted_list_ii
 * Date Created : 2024-03-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 看似简单，实则细节折磨人，看了负雪明烛的题解才勉强理解写出，记一下吧
 * @author: Admin
 * @create: 2024-03-06
 **/
public class LC82_remove_duplicates_from_sorted_list_ii {
    class SolutionSelfWrong {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode dummy = new ListNode(-200);
            dummy.next=head;
            ListNode slow = dummy,fast=dummy.next;
            int currentVal = dummy.val;
            boolean changed = false;
            while(fast!=null){
                if(fast.val==currentVal){
                    fast=fast.next;
                }else{
                    currentVal=fast.val;

                    slow.next = fast;
                    // slow=slow.next;
                    fast=fast.next;
                    changed=true;
                    if(fast!=null&&fast.val!=currentVal){
                        slow=slow.next;
                    }
                    if(changed){
                        slow=slow.next;
                    }
                }
            }
            return dummy.next;
        }
    }

    //负雪明烛
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode dummy = new ListNode(-200);
            dummy.next=head;
            ListNode slow = dummy,fast=dummy.next;

            while(fast!=null){
                // 跳过当前的重复节点，使得cur指向当前重复元素的最后一个位置
                while(fast.next!=null&&fast.val==fast.next.val){
                    fast=fast.next;
                }
                //pre和cur之间没有重复节点，pre后移
                if(slow.next==fast){
                    slow=slow.next;
                }else{
                    // pre->next指向cur的下一个位置（相当于跳过了当前的重复元素）
                    // 但是pre不移动，仍然指向已经遍历的链表结尾
                    slow.next=fast.next;
                }
                fast=fast.next;
            }
            return dummy.next;
        }
    }

    //先理思路，肯定是快慢双指针了，
    //浪费了地铁上的半个多小时，最终还是看题解，所以以后果断看题解吧，时间最重要
    class Solution20240520 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode dummy = new ListNode(-101);
            //老忘掉这一步
            dummy.next=head;
            ListNode slow=dummy,fast=dummy.next;
            while(fast!=null){
                //跳过重复节点
                while(fast.next!=null && fast.val==fast.next.val){
                    fast = fast.next;
                }
                //这一步是关键步骤，也是我一直没想起来的步骤，就是当slow和fast之间没元素时，才移动slow.
                if(slow.next==fast){
                    slow=slow.next;
                }else{
                    //指向fast.next，相当于跳过了所有重复的元素。
                    slow.next = fast.next;
                }
                fast=fast.next;

            }
            return dummy.next;
        }
    }

    class Solution20240521 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode dummy = new ListNode(-101);
            dummy.next = head;
            ListNode left = dummy, right=head;
            while(right!=null){
                //跳过重复节点
                while(right.next!=null && right.val == right.next.val){
                    right = right.next;
                }
                if(left.next==right){
                    left=left.next;
                }else{
                    left.next = right.next;
                }
                right=right.next;
            }
            return dummy.next;
        }
    }

    // 两个要点，slow向前移动的前提是slow.next=fast;用while跳过重复的节点
    //还是没能写出来，记住一点，移动完，slow不能和fast指向同一个节点。fast要先去前面探路，所以移动时要等slow移动完，再移动，这样能保持领先
    class Solution20240528 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(-101);
            dummy.next = head;
            ListNode slow=dummy,fast=head;
            while(fast!=null){
                while(fast.next!=null && fast.val==fast.next.val){
                    //fast.next!=null的条件还是要写在这个while里，因为下面fast在移动，要控制不能为空
                    fast=fast.next;
                }
                //fast=fast.next;
                if(slow.next==fast){
                    slow=slow.next;
                }else{
                    slow.next = fast.next;
                }
                fast=fast.next;
            }
            return dummy.next;
        }
    }
    //fast要一直领先于slow
    class Solution20240529 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow=dummy, fast=head;
            while(fast!=null){
                while(fast.next!=null && fast.val==fast.next.val){
                    fast=fast.next;
                }
                if(slow.next==fast){
                    slow=slow.next;
                }else{
                    slow.next=fast.next;
                }
                fast=fast.next;
            }
            return dummy.next;
        }
    }
}