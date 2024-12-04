/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestLinkedList
 * Date Created : 2023-10-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-10-15       w15021     xxx
 * --------------------------------------------------------------------
 */

import java.util.Random;

/**
 * @program: PACKAGE_NAME
 * @description: 单向链表的初始化和遍历
 * @author: w15021
 * @create: 2023-10-15
 **/
public class TestMain {
    public static void main(String[] args) {
        test2();
//        test4();
//        test5();
    }
    public static void test1(){
        System.out.println((new Random().nextInt() % 100) < 60 ? "YES" : "NO");
        System.out.println(new Random().nextInt()%100);
        String str = "LC70_climbing-stairs";
        System.out.println(str.replaceAll("-","_"));
        System.out.println("testing");
        ListNode listNode = new ListNode(-1);
        ListNode head = listNode;
        System.out.println(listNode.val);

        for (int i=0;i<5;i++){
            ListNode tempListNode = new ListNode(i);
            head.next = tempListNode;
            head = head.next;
        }
        ListNode p = listNode;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

        System.out.println("##########");
        System.out.println(-2000000000-294967296);
    }
    public static void test2(){
        String str = "longest-substring-without-repeating-characters";
        System.out.println(str.replaceAll("-","_"));
    }
    public static void test3(){
        String s = "458";

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            int temp = c-'0';
            System.out.println(temp);
            n = 10 * n + (c - '0');
        }
    }
    public static void test4(){
        System.out.println(Long.MAX_VALUE);
    }
    public static void test5(){
        System.out.println("30".compareTo("3"));
        System.out.println("3".compareTo(""));
    }

    public static void test6(){
        int a = 3&2;
        int b = 3|2;
        int c = 3^2;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    public static void test7(){
        String[] list = "1.1".split(".");
        System.out.println(list[0]);
    }
    public static void test8(){
        int num1 = Integer.valueOf("");
        System.out.println(num1);

    }
}