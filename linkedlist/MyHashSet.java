/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MyHashSet
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

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-06
 **/

class MyHashSet {

    private int BASE = 769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }

    }

    public void add(int key) {
        int h = myHashole(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                return;
            }

        }
        data[h].offerLast(key);

    }

    public void remove(int key) {
        int h = myHashole(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = myHashole(key);
        Iterator<Integer> it = data[h].iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            if (element == key) {
                return true;
            }
        }
        return false;

    }

    public int myHashole(int key) {
        return key % BASE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */