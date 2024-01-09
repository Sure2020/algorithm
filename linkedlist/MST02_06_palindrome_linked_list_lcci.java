/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MST02_06_palindrome_linked_list_lcci
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
public class MST02_06_palindrome_linked_list_lcci {
    public static void main(String[] args) {
//        int[] listInt = new int[]{1,1,2,1};
        int[] listInt = new int[]{1,2};
        ListNode listNode1=Tools.listNodeCreater(listInt);
        //System.out.println(isPalindrome(listNode1));
        //Tools.listNodePrinter(reverseLinkedList(listNode1));
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fasterPoint = head, slowerPoint=head;
        while(fasterPoint!=null && fasterPoint.next!=null){
            slowerPoint = slowerPoint.next;
            fasterPoint = fasterPoint.next.next;
        }
        if (fasterPoint!=null){
            slowerPoint = slowerPoint.next;
        }
        ListNode reversedLinkedList = reverseLinkedList(slowerPoint);
        ListNode point1 = head, point2 = reversedLinkedList;
        while(point1!=null&&point2!=null){
            if(point1.val != point2.val){
                return false;
            }
            point1 = point1.next;
            point2 = point2.next;
        }
        return true;


    }
    public ListNode reverseLinkedList (ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode last = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}