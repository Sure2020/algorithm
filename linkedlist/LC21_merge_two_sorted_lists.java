/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LeetCode21
 * Date Created : 2023-10-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-16       w15021     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 虽然再次写，也是短时间内一次通过，但这里写了while循环去逐个拼接，其实直接接到后面即可
 * @author: w15021
 * @create: 2023-10-16
 **/
public class LC21_merge_two_sorted_lists {
    public static void main(String[] args) {
        /*LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.print();*/
        System.out.println("###case1###");
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = mergeTwoLists(list1, list2);
        ListNode current = listNode;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }


        System.out.println("###case2###");
        list1 = null;
        list2 = null;
        ListNode listNode2 = mergeTwoLists(list1, list2);
        ListNode current2 = listNode2;
        while (current2 != null) {
            System.out.println(current2.val);
            current2 = current2.next;
        }


        System.out.println("###case3###");
        list1 = null;
        list2 = new ListNode(0);
        ListNode listNode3 = mergeTwoLists(list1, list2);
        ListNode current3 = listNode3;
        while (current3 != null) {
            System.out.println(current3.val);
            current3 = current3.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode currentOfResult = result;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                currentOfResult.val = p1.val;
                p1 = p1.next;
            } else {
                currentOfResult.val = p2.val;
                p2 = p2.next;
            }

            ListNode newNode = new ListNode();
            currentOfResult.next = newNode;
            currentOfResult = currentOfResult.next;

        }
        if (p1 != null) {
            currentOfResult.val = p1.val;
            currentOfResult.next = p1.next;
        } else if (p2 != null) {
            currentOfResult.val = p2.val;
            currentOfResult.next = p2.next;
        } else {
            return null;
        }
        return result;
    }

    class Solution20240302 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null){
                return list2;
            }
            ListNode dummy = new ListNode();
            ListNode p1 = list1,p2=list2,p3=dummy;
            while(p1!=null&&p2!=null){
                if(p1.val<=p2.val){
                    p3.next=p1;
                    p1=p1.next;
                    //p3=p3.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;
                    // p3=p3.next;
                }
                p3=p3.next;
            }
            // 这里，虽然再次写，也是短时间内一次通过，但这里写了while循环去逐个拼接，其实直接接到后面即可
            //while(p1!=null){
            if(p1!=null){
                // p3.next=p1;
                // p1=p1.next;
                // p3=p3.next;
                p3.next=p1;
            }
            //while(p2!=null){
            if(p2!=null){
                // p3.next=p2;
                // p2=p2.next;
                // p3=p3.next;
                p3.next=p2;
            }
            return dummy.next;
        }
    }
    //用双指针吧应该是
    //woc真牛，我短时间、独立、一次性写出来了，果然简单题名不虚传。。。
    class Solution20240516 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode p1 = list1, p2 = list2, p3 = dummy;
            while(p1!=null && p2!=null){
                if(p1.val<=p2.val){
                    p3.next=p1;
                    p1=p1.next;

                }else{
                    p3.next = p2;
                    p2=p2.next;
                }
                p3=p3.next;
            }
            if(p1!=null){
                p3.next=p1;
            }
            if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }

    //思路，双指针，分别指向两个链表，逐个比对值
    class Solution20240524 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode p1=list1,p2=list2,p3=dummy;

            int v1=-101,v2=-101;
            while(p1!=null && p2!=null){
                if(p1.val<p2.val){
                    p3.next=p1;
                    p1=p1.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;

                }
                p3=p3.next;
            }
            if(p1!=null){
                p3.next=p1;
            }
            if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }

    class Solution20240619 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode p1=list1,p2=list2,p3=dummy;

            while(p1!=null && p2!=null){
                if(p1.val<=p2.val){
                    p3.next = p1;
                    p1=p1.next;
                }else{
                    p3.next = p2;
                    p2 = p2.next;
                }
                p3 = p3.next;
            }
            if(p1!=null){
                p3.next = p1;
            }else if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }
//双指针，最后再处理一下比较长的那个链表

    class Solution20240724 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null){
                return list2;
            }else if(list2==null){
                return list1;
            }
            ListNode dummy = new ListNode();
            ListNode p1=list1,p2=list2,p3=dummy;
            while(p1!=null && p2!=null){
                if(p1.val<p2.val){
                    p3.next = p1;
                    p1=p1.next;
                }else {
                    p3.next=p2;
                    p2=p2.next;
                }
                p3=p3.next;
            }
            if(p1!=null){
                p3.next = p1;
            }
            if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }
//双指针
//事后：还行昂，一次通过

    class Solution20240904 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode p1 = list1,p2=list2,p3=dummy;
            while(p1!=null && p2!=null){
                if(p1.val<=p2.val){
                    p3.next=p1;
                    p1=p1.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;
                }
                p3=p3.next;
            }
            if(p1!=null){
                p3.next=p1;
            }else if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }
//双指针

    class Solution20241126 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null){
                return list2;
            }
            if(list2==null){
                return list1;
            }
            ListNode dummy = new ListNode();
            ListNode p1 = list1,p2=list2,p3=dummy;
            while(p1!=null && p2!=null){
                if(p1.val<=p2.val){
                    p3.next = p1;
                    p1=p1.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;
                }
                //忘了移动
                p3 = p3.next;
            }
            if(p1!=null){
                p3.next=p1;
            }
            if(p2!=null){
                p3.next=p2;
            }
            return dummy.next;
        }
    }
}