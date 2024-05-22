/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC2_add_two_numbers
 * Date Created : 2024-03-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-06       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-06
 **/
public class LC2_add_two_numbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class SolutionSelfCorrect {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode p1=l1,p2=l2,p3=dummy;
            int moreTen = 0;
            while(p1!=null&&p2!=null){
                ListNode tempNode = new ListNode(-1);
                int tempNum = p1.val+p2.val+moreTen;
                moreTen=0;
                if(tempNum<10){
                    tempNode.val=tempNum;
                    // p3.next=tempNode;
                    // p3=p3.next;
                }else{
                    int lessTen = tempNum%10;
                    moreTen = tempNum/10;
                    tempNode.val=lessTen;
                    // p3.next=tempNode;
                }
                p1=p1.next;
                p2=p2.next;
                p3.next=tempNode;
                p3=p3.next;
            }
            while(p1!=null){
                ListNode tempNode = new ListNode(-1);
                int tempNum = p1.val+moreTen;
                moreTen=0;
                if(tempNum<10){
                    tempNode.val=tempNum;
                    // p3.next=tempNode;
                    // p3=p3.next;
                }else{
                    int lessTen = tempNum%10;
                    moreTen = tempNum/10;
                    tempNode.val=lessTen;
                    // p3.next=tempNode;
                }
                p1=p1.next;
                // p2=p2.next;
                p3.next=tempNode;
                p3=p3.next;
            }
            while(p2!=null){
                ListNode tempNode = new ListNode(-1);
                int tempNum = p2.val+moreTen;
                moreTen=0;
                if(tempNum<10){
                    tempNode.val=tempNum;
                    // p3.next=tempNode;
                    // p3=p3.next;
                }else{
                    int lessTen = tempNum%10;
                    moreTen = tempNum/10;
                    tempNode.val=lessTen;
                    // p3.next=tempNode;
                }
                // p1=p1.next;
                p2=p2.next;
                p3.next=tempNode;
                p3=p3.next;
            }
            //注意处理最后一位的进位
            if(moreTen!=0){
                ListNode tempNode = new ListNode(moreTen);
                p3.next=tempNode;
            }
            return dummy.next;
        }
    }

    //自己独立写的思路，其实和labuladong的思路一致，只不过代码不够精简，下面是精简后的
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode p1=l1,p2=l2,p3=dummy;
            int moreThanTen = 0;
            while(p1!=null||p2!=null||moreThanTen>0){
                int val = moreThanTen;
                ListNode tempNode = new ListNode(-1);
                if(p1!=null){
                    val += p1.val;
                    p1=p1.next;
                }
                if(p2!=null){
                    val+=p2.val;
                    p2=p2.next;
                }
                tempNode.val=val%10;
                moreThanTen=val/10;
                p3.next=tempNode;
                p3=p3.next;
            }
            return dummy.next;
        }
    }

    //牛，早上，晚上的两趟地铁，终究是独立写出来了，没看任何提示，虽然代码繁琐但毕竟是自己独立写的，以后就这么写！
    class Solution20240522 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode p1=l1,p2=l2,p3=dummy;

            int moreThanTen = 0;
            while(p1!=null && p2!=null){
                int v1=p1.val,v2=p2.val;
                int sum = v1+v2;
                // 这里要将v1 v2 moreThanTen加起来，再取模，取余，考虑[3,7]，[9,2]这个测试用例
                // int v3=sum%10 + moreThanTen;
                int v3=(sum + moreThanTen)%10;
                //这里错写成了v3/10
                // moreThanTen = sum/10;
                moreThanTen = (sum + moreThanTen)/10;
                ListNode tempNode = new ListNode(v3);
                p3.next=tempNode;
                p3=p3.next;

                //忘了移动这两个指针
                p1=p1.next;
                p2=p2.next;
            }
            //处理p1较长的情况
            while(p1!=null){
                int sum = p1.val + moreThanTen;
                int v3 = sum%10;
                moreThanTen = sum/10;
                ListNode tempNode = new ListNode(v3);
                p3.next = tempNode;
                p3=p3.next;
                p1=p1.next;
            }
            //处理p2较长的情况
            while(p2!=null){
                int sum = p2.val + moreThanTen;
                int v3 = sum%10;
                moreThanTen = sum/10;
                ListNode tempNode = new ListNode(v3);
                p3.next = tempNode;
                p3=p3.next;
                p2=p2.next;
            }

            //处理仍然有进位的情况
            if(moreThanTen!=0){
                ListNode tempNode = new ListNode(moreThanTen);
                p3.next = tempNode;
            }
            return dummy.next;
        }
    }
}