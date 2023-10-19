/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LC23_merge_k_sorted_lists
 * Date Created : 2023-10-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-18       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: w15021
 * @create: 2023-10-18
 **/
public class LC23_merge_k_sorted_lists {
    public static void main(String[] args) {

        System.out.println("case1");
        ListNode list1_1 = Tools.listNodeCreater(new int[]{1, 4, 5});
        ListNode list1_2 = Tools.listNodeCreater(new int[]{1, 3, 4});
        ListNode list1_3 = Tools.listNodeCreater(new int[]{2, 6});
        ListNode[] lists1 = new ListNode[]{list1_1, list1_2, list1_3};

        Tools.listNodePrinter(mergeKLists_labuladong(lists1));

        System.out.println("case2");
        ListNode[] lists2 = new ListNode[]{};
        Tools.listNodePrinter(mergeKLists_labuladong(lists2));

        System.out.println("case3");
        ListNode list3_1 = null;
        ListNode[] lists3 = new ListNode[]{null};
        Tools.listNodePrinter(mergeKLists_labuladong(lists3));
    }

    static ListNode mergeKLists_labuladong(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists_my(ListNode[] lists) {
        List<Integer> allValList = new ArrayList<Integer>();
        for (ListNode listNodeI : lists) {
            ListNode headI = listNodeI;
            while (headI != null) {
                allValList.add(headI.val);
                headI = headI.next;
            }
        }
        System.out.println("before sort");
        for (int i : allValList) {
            System.out.print(i);
        }
        System.out.println();
        Collections.sort(allValList);
        System.out.println("after sort");
        for (int i : allValList) {
            System.out.print(i);
        }
        System.out.println();

        ListNode dummy = new ListNode(-999);
        ListNode head = dummy;
        for (int i : allValList) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dummy.next;
    }
}