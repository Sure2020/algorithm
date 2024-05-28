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
//        Solution20240520 solution20240520 = new Solution20240520();
//        System.out.println(solution20240520.detectCycle(list1).val);

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

    //先理清思路：自己想到了k，2k和k-x，没想到关键的一步，就是快慢指针相遇后，再同速走k-x步，再次相等的点就是目标节点
    public class Solution20240520 {
        public ListNode detectCycle(ListNode head) {
            if(head==null || head.next==null){
                return null;
            }
            //注意，自己给自己挖的大坑，这里slow指向head,没动位置，而fast却已走两步。。。
            // 以后还是把移动的逻辑放到while里面，这样能规避这个低级错误
            ListNode /*slow=head*/slow=head.next,fast=head.next.next;
            boolean hasCycle = false;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast=fast.next.next;
                if(fast==slow){
                    hasCycle = true;
                    break;
                }
            }
            if(!hasCycle){
                return null;
            }
            slow = head;
            while(slow!=fast){
                slow=slow.next;
                // 注意，这里也是写错了，两个指针要同速走！
                //fast = fast.next.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    //先理清思路：快指针每次走两步，和慢指针相遇后，再同速走k-m步
    public class Solution20240521 {
        public ListNode detectCycle(ListNode head) {
            if(head==null || head.next==null){
                return null;
            }
            ListNode slow=head, fast=head;
            while(fast!=null && fast.next !=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    break;
                }
            }
            if(fast==null || fast.next==null){
                return null;
            }
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;

        }
    }

    //快慢指针，快指针每次走两步，当和慢指针相遇，则让慢指针从head开始，与另一个指针每次一步前进，再次相遇就是所求点
    //挺牛的，快速敲完了，而且一遍过
    public class Solution20240528 {
        public ListNode detectCycle(ListNode head) {
            if(head==null || head.next==null){
                return null;
            }
            ListNode slow=head,fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    break;
                }
            }
            if(fast==null || fast.next==null){
                return null;
            }
            //slow 从Head开始
            slow = head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }
}