/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC705_design_hashset
 * Date Created : 2024-01-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-06       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedList;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-06
 **/
public class LC705_design_hashset {
    public static void main(String[] args) {
        LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
        testLinkedList.offerLast(1);
        testLinkedList.offerLast(2);
        System.out.println(testLinkedList.contains(2));
        testLinkedList.remove(Integer.valueOf(2));
        System.out.println(testLinkedList.contains(2));
        System.out.println("#####");
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // 返回 True
        myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // 返回 False ，（已移除）
    }
}

