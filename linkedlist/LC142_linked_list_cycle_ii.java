/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC141_linked_list_cycle_ii
 * Date Created : 2023-10-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-23       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 第二次做，一来思路忘了，二来有一处失误导致死循环，需要反复巩固
 * @author: w15021
 * @create: 2023-10-23
 **/
public class LC142_linked_list_cycle_ii {
    public static void main(String[] args) {
        System.out.println("case1, pos=1");
        ListNode list1 = Tools.listNodeCreater(new int[]{3, 2, 0, -1});
        ListNode head1 = list1;
        ListNode pos1 = list1;
        while (head1.next != null) {
            head1 = head1.next;
        }
        pos1 = pos1.next;
        head1.next = pos1;
        System.out.println(detectCycle(list1).val);

        System.out.println("case2, pos=0");
        ListNode list2 = Tools.listNodeCreater(new int[]{1, 2});
        ListNode head2 = list2;
        ListNode pos2 = list2;
        while (head2.next != null) {
            head2 = head2.next;
        }
        head2.next = pos2;
        System.out.println(detectCycle(list2).val);

        System.out.println("case3, pos=-1");
        ListNode list3 = Tools.listNodeCreater(new int[]{1});
        //System.out.println(detectCycle(list3).val);
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode slowerPoint = head;
        ListNode fasterPoint = head;

        while (fasterPoint != null && fasterPoint.next != null) {
            slowerPoint = slowerPoint.next;
            fasterPoint = fasterPoint.next.next;
            if (slowerPoint == fasterPoint) {
                slowerPoint = head;
                /*if(slowerPoint == fasterPoint){
                    return slowerPoint;
                }
                while (slowerPoint != null) {
                    slowerPoint = slowerPoint.next;
                    fasterPoint = fasterPoint.next;
                    if (slowerPoint == fasterPoint) {
                        return slowerPoint;
                    }
                }*/
                while (slowerPoint!=fasterPoint){
                    slowerPoint = slowerPoint.next;
                    fasterPoint = fasterPoint.next;
                }
                return slowerPoint;
            }
        }
        return null;
    }
    public class Solution20240303 {
        public ListNode detectCycle(ListNode head) {
            if(head==null||head.next==null){
                return null;
            }
            //这里出现了失误，要假定双指针都从起点开始走。一开始写成了slow=head，导致死循环
            ListNode slow=head.next, fast = head.next.next;
            while(fast!=null&&fast.next!=null){
                //System.out.println("###"+slow.val+"###"+fast.val);
                if(slow==fast){
                    break;
                }else{
                    slow=slow.next;
                    fast=fast.next.next;
                }
            }
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    //System.out.println(slow.val+"###"+fast.val);
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }else{
                return null;
            }
        }
    }
}