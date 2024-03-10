/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC138_copy_list_with_random_pointer
 * Date Created : 2024-03-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-10       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 这个思路自己想不到，需要练一下
 * @author: Admin
 * @create: 2024-03-10
 **/
public class LC138_copy_list_with_random_pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> clone = new HashMap<>();
            for(Node p =head;p!=null;p=p.next){
                clone.put(p,new Node(p.val));
            }
            for(Node p = head;p!=null;p=p.next){
                clone.get(p).next = clone.get(p.next);
                clone.get(p).random = clone.get(p.random);
            }
            return clone.get(head);
        }
    }
}