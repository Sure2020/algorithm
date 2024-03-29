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
}