/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LinkedListReversePrintOrder
 * Date Created : 2024-03-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-05       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 为了体会MST02_02_kth_node_from_end_of_list_lcci这一题的递归思路
 * @author: Admin
 * @create: 2024-03-05
 **/
public class LinkedListReversePrintOrder {
    public static void main(String[] args) {
        ListNode head = Tools.listNodeCreater(new int[]{1,2,3,4,5});
        Tools.listNodePrinter(head);
        print(head,2);
        System.out.println(result);
    }
    static int count=0;
    static int result = -1;
    public static void print(ListNode head, int k){
        if(head==null){
            return ;
        }
        print(head.next, k);
        //System.out.println(head.val);
        count++;
        if(count==k){
            //System.out.println(head.val);
            result=head.val;
        }
    }
}