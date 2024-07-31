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

import java.util.*;

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

        //Tools.listNodePrinter(mergeKLists_labuladong(lists1));

        Tools.listNodePrinter(Solution20240516.mergeKLists(lists1));

        System.out.println("case2");
        ListNode[] lists2 = new ListNode[]{};
        Tools.listNodePrinter(mergeKLists_labuladong(lists2));

        System.out.println("case3");
        ListNode list3_1 = null;
        ListNode[] lists3 = new ListNode[]{null};
        Tools.listNodePrinter(mergeKLists_labuladong(lists3));

        ListNode list2_1 = Tools.listNodeCreater(new int[]{-2,-1,-1,-1});
        ListNode list2_2 = Tools.listNodeCreater(new int[]{});
        ListNode[] lists22 = new ListNode[]{list2_1, list2_2};
        Tools.listNodePrinter(Solution20240516.mergeKLists(lists22));
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

    //第一反应，用小顶堆吧应该是
    //果然是小顶堆，奈何我忘了小顶堆怎么写
    static class Solution20240516 {//有问题，会成环，一股脑往queue里放的思路废弃，要先一次性放头结点，再逐个放后面的节点
        public static ListNode mergeKLists(ListNode[] lists) {
            //就是因为没判断0，然后一直报错java.lang.IllegalArgumentException想了好久
            if(lists.length==0){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    //如果不加这个判断，用例[[-2,-1,-1,-1],[]]会造成死锁，因为值一样时，如果不指定那个元素优先，则会随机二选一，值相同的节点，顺序会随机
                    //labuladong的不会出现死锁，是因为对于同一个链表，他是往小顶堆中放一个，再立马取一个，无形中控制了顺序
                    //还是过不了！这个[[-1,-1,-1],[-2,-2,-1]]，所以果断放弃自己的这个解法，改用labuladong的！也不去调了，避免浪费时间！时间很宝贵啊现在对于我来说！
                    if(o1.val==o2.val){
                        return -1;
                    }
                    return o1.val-o2.val;
                }
            });
            for(int i=0;i<lists.length;i++){
                ListNode p = lists[i];
                while(p!=null){
                    queue.add(p);
                    p=p.next;
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while(!queue.isEmpty()){
                ListNode node = queue.poll();
                p.next=node;
                p=p.next;
            }
            return dummy.next;
        }
    }

    // 第一反应，用小顶堆吧应该是
// 果然是小顶堆，奈何我忘了小顶堆怎么写
    class Solution20240516Labuladong {
        public ListNode mergeKLists(ListNode[] lists) {
            // 就是因为没判断0，然后一直报错java.lang.IllegalArgumentException想了好久
            if (lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                ListNode p = lists[i];
                //注意，null的别放
                if(p!=null){
                    //只放头结点先
                    queue.add(p);
                }

            }
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;
                if(node.next!=null){
                    queue.add(node.next);
                }
                p = p.next;
            }
            return dummy.next;
        }
    }

    //小顶堆，先将各链表头节点放入堆，再取节点
    class Solution20240517 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0){
                return null;
            }
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b)->(a.val-b.val));
            for(int i=0;i<lists.length;i++){

                ListNode head = lists[i];
                if(head!=null){
                    pq.add(head);
                }
            }
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            while(!pq.isEmpty()){
                ListNode node = pq.poll();
                p.next=node;
                p=p.next;
                if(node.next!=null){
                    pq.add(node.next);
                }
            }
            return dummy.next;
        }
    }

    //先理思路：利用小顶堆。注意：先将各列表的头节点放入小顶堆，再逐个向后取，放，拼
    class Solution20240518 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0){
                return null;
            }
            //注意1 new 后面的尖括号别落下
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b)->(a.val-b.val));
            for(int i=0;i<lists.length;i++){
                ListNode head = lists[i];
                if(head!=null){
                    queue.add(head);
                }
            }
            ListNode dummy = new ListNode();
            // 注意2 p要指向dummy，别觉得自己滚瓜烂熟就思路松懈，要想清楚每一步的意图！
            // ListNode p = new ListNode();
            ListNode p = dummy;
            while(!queue.isEmpty()){
                ListNode node = queue.poll();
                p.next=node;
                if(node.next!=null){

                    queue.add(node.next);
                }
                p=p.next;
            }
            // 注意3，要return dummy.next.......看来按记忆做题真的很危险
            // return dummy;
            return dummy.next;
        }
    }

    //先将头节点放入小顶堆，再取出顶元素，再逐个放入后面的节点，边放边取
    //很多小细节需要注意，不用特意记忆，靠测试用例来推动改正吧
    class Solution20240525 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0){
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
            for(int i=0;i<lists.length;i++){
                ListNode tempNode = lists[i];
                if(tempNode!=null){
                    queue.add(tempNode);
                }
            }
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            while(!queue.isEmpty()){
                ListNode tempNode = queue.poll();
                p.next = tempNode;
                p=p.next;
                if(tempNode.next!=null){
                    queue.add(tempNode.next);
                }
            }
            return dummy.next;
        }
    }

    class Solution20240625 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            Queue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b)->(a.val-b.val));


            for(int i=0;i<lists.length;i++){
                ListNode tempNode = lists[i];
                if(tempNode==null){
                    continue;
                }
                //System.out.println(tempNode.val);
                queue.offer(tempNode);
            }
            while(!queue.isEmpty()){
                //每次把各个链表的第一个节点都放进小顶堆，最后只取顶上的一个
                ListNode tempNode = queue.poll();
                p.next = tempNode;
                p = p.next;
                if(tempNode.next!=null){
                    queue.offer(tempNode.next);
                }
            }
            return dummy.next;
        }
    }
//嗯，小顶堆

    class Solution20240731 {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            for(int i=0;i<lists.length;i++){
                //System.out.println(lists[i].val);
                ListNode tempNode = lists[i];
                if(tempNode!=null){
                    //System.out.println(lists[i].val);
                    queue.offer(lists[i]);
                }

            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0;i<size;i++){
                    ListNode tempNode = queue.poll();
                    p.next = tempNode;
                    p=p.next;
                    if(tempNode.next!=null){
                        queue.offer(tempNode.next);
                    }
                }
            }
            return dummy.next;
        }
    }
//小顶堆
//事后：不错，几次就调试出来了
}