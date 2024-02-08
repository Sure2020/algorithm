/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC1650_lowest_common_ancestor_of_a_binary_tree_iii
 * Date Created : 2024-02-08
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-08       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-02-08
 **/
public class LC1650_lowest_common_ancestor_of_a_binary_tree_iii {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    class Solution {
        public Node lowestCommonAncestor(Node p, Node q) {
            Node node1 = p,node2=q;
            //这里有个小失误，明明另外声明了两个指针，但在下面操作时还是直接用了p和q，马虎了
            while(node1!=node2){
                node1 = node1.parent;
                if(node1==null){
                    node1=q;
                }
                node2 = node2.parent;
                if(node2==null){
                    node2=p;
                }
            }
            return node2;
        }
    }
}