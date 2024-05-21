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
}