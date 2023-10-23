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
}