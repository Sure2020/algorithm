/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC_remove_nth_node_from_end_of_list
 * Date Created : 2023-10-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-19       w15021     xxx
 * --------------------------------------------------------------------
 */

import javax.tools.Tool;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-19
 **/
public class LC19_remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode list1 = Tools.listNodeCreater(new int[]{1, 2, 3, 4, 5});
        Tools.listNodePrinter(removeNthFromEnd(list1, 5));

        System.out.println("case3");
        ListNode list3 = Tools.listNodeCreater(new int[]{1, 2});
        Tools.listNodePrinter(removeNthFromEnd(list3, 1));

        System.out.println("new test");
        Solution20240520 solution20240520 = new Solution20240520();
        Tools.listNodePrinter(solution20240520.removeNthFromEnd(list1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-999);
        dummy.next = head;
        ListNode fasterHead = dummy;
        ListNode slowerHead = dummy;

        for (int i=1;i<=n;i++){
            if (fasterHead != null){
                fasterHead = fasterHead.next;
            }
        }
        while (fasterHead.next!=null){
            fasterHead = fasterHead.next;
            slowerHead = slowerHead.next;
        }
        //System.out.println("current node val: " + slowerHead.val);
        /*ListNode tempNode = slowerHead.next;
        slowerHead.next = tempNode.next;*/
        slowerHead.next = slowerHead.next.next;
        return dummy.next;
    }

    //第二次做，虽然有点曲折，但还是独立做出来了
    class Solution20240304 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            if(head.next==null&&n==1){
                return null;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow=dummy,fast=dummy;

            for(int i=1;i<=n;i++){
                fast=fast.next;

            }
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            slow.next=slow.next.next;
            return dummy.next;
        }
    }

    //先理清思路：递归先找到倒数第n
    // 同理，删除倒数第n个节点，用快慢指针也是更简单！！！
    static class Solution20240520 {
        int count =0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return head;
            }
            //注意，一开始没写这个head.next = ，导致删除节点后的链表没载体能够传递给最开始的调用者
            head.next = removeNthFromEnd(head.next,n);
            count ++;
            if(count==n){
                return head.next;
            }
            return  head;
        }

    }

    class Solution20240521 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null || head.next==null){
                return null;
            }
            //注意，搞了个dummy节点，就能处理倒数第n个节点是第一个节点的情况了
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow=dummy,fast=dummy;
            for(int i=1;i<=n;i++){
                fast=fast.next;
                //System.out.println(fast.val);
            }
            //控制fast指向最后一个节点，而不是null节点
            while(fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    //第一时间能想到的还是递归；tips:只要需要删除节点，就搞dummy节点辅助
    class Solution20240528 {
        private int count = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //不能当head.next==null时return head，因为head这一个节点要被删掉，所以要return null
            if(head==null){
                return null;
            }
            // ListNode dummy = new ListNode();
            // dummy.next = head;
            // remove(dummy, n);
            // return dummy.next;
            //return remove(head, n);
            head.next=removeNthFromEnd(head.next,n);
            count ++;
            if(count==n){
                return head.next;
            }
            return head;
        }

        public ListNode remove(ListNode head, int n){
            //base case
            if(head==null){
                return null;
            }

            head.next=remove(head.next, n);
            count++;
            //base case
            if(count==n){
                return head.next;
            }
            return head;
        }
    }

    //思路的演变过程见上一次提交
    class Solution202405282119 {
        private int count = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //base case
            if(head==null){
                return null;
            }
            head.next = removeNthFromEnd(head.next, n);
            count ++;
            if(count ==n){
                return head.next;
            }
            return head;
        }
    }

    class Solution20240701 {
        int count = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            // if(head==null || head.next==null){
            //     return head;
            // }
            // if(n==1){
            //     return head.next;
            // }
            ListNode dummy = new ListNode();
            dummy.next = head;
            head.next = removeNthFromEnd(head.next,n);
            count ++;
            if(count==n){
                return head.next;
            }
            return dummy.next;
        }
    }
//删除链表的题目，首先直接一个dummy节点写出来。。。
//删除倒数第n个，那对于head.next,就是删除倒数第n-1个，对于某个head,就是删除自己

//哈哈。。。。难道这就是无招胜有招？？一开始思路一团糟，后来慢慢想到利用递归，可以从后往前计数，关键是计数到第n个时，返回head.next，相当于跳过了当前节点。
//关键还是对后续遍历的理解，count++放在递归调用的后面！

    class Solution2024080501 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            ListNode dummy=new ListNode();
            dummy.next = head;
            ListNode slow=dummy,fast=dummy;
            //System.out.println("fast: " + fast.val);
            //System.out.println("fast.next: " + fast.next.val);
            for(int i=1;i<=n;i++){
                //System.out.println("fast: testing:   " + fast.val + "  i: " + i);
                //System.out.println(fast.next.val);
                fast=fast.next;
            }
            // if(fast==null){
            //     System.out.println("nul");
            // }
            //System.out.println("fast: " + fast.val);
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            // System.out.println("slow: " + slow.val);
            //System.out.println("slow: " + slow.val+" fast: " + fast.val);
            slow.next=slow.next.next;
            return dummy.next;
        }
    }
//递归。有一处返回head.next，就达到跳过倒数第n个节点的效果
//...没做出来，换个思路，先找到倒数N个节点
//事后：太慌了，心不静，太着急了，搞错很多出细节，而且忘了dummy，对dummy这个技巧不敏感

    class Solution2024080502 {
        int k=0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //base case
            if(head==null){
                return null;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;

            head.next=removeNthFromEnd(head.next,n);
            k++;
            if(k==n){
                return head.next;
            }
            return dummy.next;
        }
    }
//重来：如果需要计算正数n个，就把count+1并作为参数传入下一次递归；如果要计算倒数n个，就搞个全局count变量来记录，count在递归内部++；
//这里关键是k++在递归函数之后，是为了先让递归函数去触发base case，让递归开始逐层返回，开始返回了，才可以开始count++。或者这么说，都是需要先触发base case，再进行特殊处理。

    class Solution20250518 {
        int count=0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            ListNode dummy = new ListNode();
            //删除链表的题目，首先直接一个dummy节点写出来。。。
            //删除倒数第n个，那对于head.next,就是删除倒数第n-1个，对于某个head,就是删除自己
            dummy.next=head;
            head.next = removeNthFromEnd(head.next,n);
            count++;
            if(count==n){
                return head.next;
            }
            return dummy.next;
        }
    }

    class Solution20250525 {
        int count=0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head==null){
                return null;
            }
            ListNode dummy=new ListNode();
            dummy.next=head;
            head.next=removeNthFromEnd(head.next,n);
            count++;
            if(count==n){
                return head.next;
            }
            //相当于return head
            return dummy.next;
        }
    }
}