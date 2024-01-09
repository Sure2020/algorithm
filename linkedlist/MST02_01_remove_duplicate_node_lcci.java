/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MST02_01_remove_duplicate_node_lcci
 * Date Created : 2024-01-09
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-09       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-09
 **/
public class MST02_01_remove_duplicate_node_lcci {
    public static void main(String[] args) {
        int[] listInt = new int[]{1,2,3,3,2,1};
        ListNode listNode1=Tools.listNodeCreater(listInt);
        //removeDuplicateNodes(listNode1);

    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        Set<Integer> existSet = new HashSet();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;
        // while (cursor.next != null){
        //     if(existSet.contains(cursor.next.val)){
        //         cursor.next = cursor.next.next;
        //     }else {
        //         existSet.add(cursor.next.val);
        //         cursor = cursor.next;
        //     }
        // }
        // return head;
        while(current!=null){
            if(existSet.contains(current.val)){
                previous.next = previous.next.next;
                current = previous.next;
            }else{
                existSet.add(current.val);
                previous = previous.next;
                current = current.next;
            }
        }
        return dummy.next;
    }
}