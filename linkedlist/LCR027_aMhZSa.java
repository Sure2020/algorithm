/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LCR027_aMhZSa
 * Date Created : 2024-01-09
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-09       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-09
 **/
public class LCR027_aMhZSa {
    public static void main(String[] args) {
        //int[] listInt = new int[]{1,2,2,1,3};
        int[] listInt = new int[]{1,2,2,1};
//        int[] listInt = new int[]{1,2};
        ListNode listNode1=Tools.listNodeCreater(listInt);
        System.out.println(isPalindrome(listNode1));
        //Tools.listNodePrinter(reverseLinkedList(listNode1));
        Tools.listNodePrinter(listNode1);
        //Tools.listNodePrinter(reverseIterator(listNode1));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode fistHalfEnd = getHalfOfLinkedList(head);
        ListNode secondHalfStart = reverse(fistHalfEnd.next);
        // judge
        boolean result = judge(head, secondHalfStart);
        // recover head
        fistHalfEnd.next = reverse(secondHalfStart);
        return result;

    }
    public static ListNode getHalfOfLinkedList(ListNode head){
        ListNode fasterPoint = head, slowerPoint = head;
        while(fasterPoint.next!=null&&fasterPoint.next.next!=null){
            fasterPoint = fasterPoint.next.next;
            slowerPoint = slowerPoint.next;
        }
        return slowerPoint;
    }
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    /*public static ListNode reverseIterator (ListNode head){
        if (head == null || head.next == null) {
            return null;
        }
        ListNode previous = null, current = head, currentNext = null;
        while (current!=null){
            currentNext = current.next;
            current.next = previous;
            previous = current;
            current = currentNext;
        }
        return previous;
    }*/
    public static boolean judge(ListNode head1, ListNode head2){
        ListNode cursor1 = head1, cursor2 = head2;
        if(head1==null||head2==null){
            return false;
        }
        while(head1!=null && head2!=null){
            if(head1.val!=head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}