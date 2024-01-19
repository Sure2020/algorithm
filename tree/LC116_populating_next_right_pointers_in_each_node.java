/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC116_populating_next_right_pointers_in_each_node
 * Date Created : 2024-01-19
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-19       Admin     xxx
 * --------------------------------------------------------------------
 */

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-19
 **/
public class LC116_populating_next_right_pointers_in_each_node {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        traverse(root.left,root.right);
        return root;
    }
    public void traverse(Node node1, Node node2){
        if(node1==null||node2==null){
            return;
        }
        node1.next = node2;
        traverse(node1.left,node1.right);
        traverse(node1.right,node2.left);
        traverse(node2.left, node2.right);

    }
}