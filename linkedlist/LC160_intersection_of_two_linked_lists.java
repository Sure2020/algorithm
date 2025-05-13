/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC160_intersection_of_two_linked_lists
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
public class LC160_intersection_of_two_linked_lists {
    public static void main(String[] args) {
        System.out.println("case1");
        ListNode list1_1 = Tools.listNodeCreater(new int[]{4, 1, 8, 4, 5});
        ListNode list1_2 = Tools.listNodeCreater(new int[]{5, 6, 1});
        ListNode head1_1 = list1_1;
        ListNode head1_2 = list1_2;
        while (head1_1.val != 8) {
            head1_1 = head1_1.next;
        }
        while (head1_2.next != null) {
            head1_2 = head1_2.next;
        }
        head1_2.next = head1_1;

        //Tools.listNodePrinter(getIntersectionNode(list1_1, list1_2));
        System.out.println(getIntersectionNode_labuladong(list1_1, list1_2).val);

        System.out.println("case3");
        ListNode list3_1 = Tools.listNodeCreater(new int[]{2,6,4});
        ListNode list3_2 = Tools.listNodeCreater(new int[]{1,5});
        System.out.println(getIntersectionNode_labuladong(list3_1, list3_2).val);
    }
    public static ListNode getIntersectionNode_labuladong(ListNode headA, ListNode headB) {
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        while(currentNodeA != currentNodeB){
            if (currentNodeA == null){
                currentNodeA = headB;
            } else {
                currentNodeA = currentNodeA.next;
            }

            if (currentNodeB == null){
                currentNodeB = headA;
            } else {
                currentNodeB = currentNodeB.next;
            }
        }

        return currentNodeA;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentNodeA1 = headA;
        ListNode currentNodeA2 = headB;

        ListNode currentNodeB1 = headB;
        ListNode currentNodeB2 = headA;
        while(currentNodeA2 != currentNodeB2){
            if(currentNodeA1.next != null){
                currentNodeA1 = currentNodeA1.next;
            } else if (currentNodeA2.next != null){
                currentNodeA2 = currentNodeA2.next;
            } else {
                return null;
            }

            if(currentNodeB1.next != null){
                currentNodeB1 = currentNodeB1.next;
            } else if (currentNodeB2.next != null){
                currentNodeB2 = currentNodeB2.next;
            } else {
                return null;
            }

        }

        return currentNodeA2;
    }
    public class Solution202403030826 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null/*||headA.next==null*/||headB==null/*||headB.next==null*/){
                return null;
            }
            // if(headA==headB){
            //     return headA;
            // }
            ListNode p1=headA,p2=headB;
            while(p1!=null&&p2!=null){
                //System.out.println("###"+p1.val+"###"+p2.val);
                if(p1==p2){
                    return p1;
                }
                p1=p1.next;
                p2=p2.next;
                if(p1==null&&p2==null){
                    return null;
                }

                if(p1==null){
                    p1=headB;
                }
                if(p2==null){
                    p2=headA;
                }

            }
            return null;
        }
    }

    //当没有交点，最后p1==p2==null，也就是结束的条件，有一点技巧性，记一下
    public class Solution202403030831 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1=headA,p2=headB;
            while(p1!=p2){
                if(p1==null){
                    p1 = headB;
                }else{
                    p1=p1.next;
                }
                if(p2==null){
                    p2=headA;
                }else{
                    p2=p2.next;
                }
            }
            return p1;
        }
    }

    //先理清思路：双指针，拼成ab和ba两条链表，并搞两个指针分别遍历，如果相交则肯定会有个位置，两个指针指向同一个节点
    //还行，自己调了几次解决了，简单题确实简单
    public class Solution20240520 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB== null){
                return null;
            }
            ListNode p1 = headA, p2 = headB;
            while(true){
                //说明已到达尾部
                if(p1==null && p2==null){
                    return null;
                }
                if(p1==p2){
                    break;
                }
                if(p1==null){
                    p1=headB;
                }else{
                    p1=p1.next;
                }
                if(p2==null){
                    p2=headA;
                }else{
                    p2=p2.next;
                }
                // p1=p1.next;
                // p2=p2.next;
            }
            return p1;
        }
    }
    //思路：将两条链表拼成一条，就可以用双指针遍历了
    public class Solution20240527 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA,p2=headB;
            while(p1!=null || p2!=null){
                if(p1==p2){
                    return p1;
                }
                //System.out.println(p1.val);
                p1=p1.next;
                p2=p2.next;
                // 卡在了这一步，要及时判断是否都走到了终点，并推出while，否则会死循环
                if(p1==null && p2==null){
                    return null;
                }
                if(p1==null){
                    p1=headB;
                }

                //System.out.println(p2.val);
                //p2=p2.next;
                if(p2==null){
                    p2=headA;
                }
            }
            return null;
        }
    }

    public class Solution20240626 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1=headA,p2=headB;
            // int count=1;
            while(p1!=null && p2!=null){
                if(p1==p2){
                    //System.out.println("found it");
                    return p1;
                }

                // System.out.println("p1: " + p1.val);
                // System.out.println("p2: " + p2.val);
                p1=p1.next;
                p2=p2.next;
                if(p1==null && p2==null){
                    return null;
                }
                if(p1==null){
                    p1=headB;
                }
                if(p2==null){
                    p2=headA;
                }
            }
            return null;
        }
    }
//双指针，各走完A再走B
//确实有几处细节，主要是判空、判等的位置，有讲究，不用硬记，面向测试用例编程即可~

    public class Solution20240731 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (p1 != null && p2 != null) {
                //System.out.println("p1: " + p1.val + " p2: " + p2.val);
                if (p1 == p2) {
                    return p1;
                }

                p1 = p1.next;
                p2 = p2.next;

                if(p1==null && p2==null){
                    return null;
                }
                if (p1 == null) {
                    p1 = headB;
                }
                if (p2 == null) {
                    p2 = headA;
                }

            }
            return null;
        }
    }
// 思路是两条链表拼接成一条链表
//事后：搞清楚两条链表拼接后的样子，思路就顺畅了，可借助纸笔

    public class Solution20240912 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB==null){
                return null;
            }

            ListNode p1 = headA,p2=headB;
            if(p1==p2){
                return p1;
            }
            while(p1!=null){
                p1=p1.next;
                p2=p2.next;
                if(p1==p2){
                    return p1;
                }
                if(p1==null){
                    p1=headB;
                }
                if(p2==null){
                    p2=headA;
                }
                if(p1==p2){
                    return p1;
                }
            }
            return null;
        }
    }
//快慢指针先相遇，然后任意一个指针从头开始，另一个不变，同步前进再次相遇就是交叉点。
//搞错了，没注意审题。此题方法是拼起来

    public class Solution20241127_labuladong {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2=headB;
            while(p1!=p2){
                if(p1==null){
                    p1=headB;
                }else{
                    p1=p1.next;
                }

                if(p2==null){
                    p2=headA;
                }else{
                    p2=p2.next;
                }
            }
            return p1;
        }
    }
//搞错了，没注意审题。此题方法是拼起来
//快慢指针先相遇，再同速前进的是寻找成环的节点
//labuladong的思路，将两支拼起来，不管相交与否，总会有p1=p2的时候，比如都为null


    public class Solution20250513 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB==null){
                return null;
            }
            ListNode p1 = headA,p2=headB;
            while(p1!=p2){
                if(p1==null){
                    p1=headB;
                }else{
                    p1=p1.next;
                }
                if(p2==null){
                    p2=headA;
                }else{
                    p2=p2.next;
                }
            }
            return p1;
        }
    }
}