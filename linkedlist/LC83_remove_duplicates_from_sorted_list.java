/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC83_remove_duplicates_from_sorted_list
 * Date Created : 2023-10-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-24       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-24
 **/
public class LC83_remove_duplicates_from_sorted_list {
    public static void main(String[] args) {
        System.out.println("case1");
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 1, 2});
        Tools.listNodePrinter(deleteDuplicates(list1));
        System.out.println("case2");
        ListNode list2 = Tools.listNodeCreater(new int[]{1, 1, 2, 3, 3});
        Tools.listNodePrinter(deleteDuplicates(list2));
        System.out.println("case3");
        ListNode list3 = Tools.listNodeCreater(new int[]{});
        Tools.listNodePrinter(deleteDuplicates(list3));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fasterPoint = head;
        ListNode slowerPoint = head;
        while (fasterPoint != null && fasterPoint.next != null) {
            fasterPoint = fasterPoint.next;
            if (slowerPoint.val != fasterPoint.val) {
                slowerPoint.next = fasterPoint;
                slowerPoint = fasterPoint;
            }
        }
        slowerPoint.next = null;
        return head;
    }
    //第二次写稍微有点失误，一开始想用单节点，结果无法处理所有节点值都相同的情况，最后还是逃不过快慢双指针
    class Solution20240310 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode slow = head,fast=head.next;
            while(fast!=null){
                if(slow.val==fast.val){
                    slow.next=fast.next;
                }else{
                    slow=slow.next;
                }
                fast=fast.next;
            }
            return head;
        }
    }
}