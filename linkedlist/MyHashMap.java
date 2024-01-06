/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MyHashMap
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
class MyHashMap {
    class Pair {
        private int key;
        private int value;
        Pair(){

        }
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return key;
        }
        public void setKey(int key){
            this.key = key;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value){
            this.value = value;
        }

    }
    private int BASE = 769;
    private LinkedList<Pair>[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            data[i] = new LinkedList<Pair>();
        }

    }

    public void put(int key, int value) {
        int h = myhash(key);
        Iterator<Pair> it = data[h].iterator();
        while(it.hasNext()){
            Pair element = it.next();
            if(element.getKey() == key){
                element.value = value;
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));

    }

    public int get(int key) {
        int h = myhash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()){
            Pair element = it.next();
            if(element.getKey() == key){
                return element.getValue();
            }
        }
        return -1;

    }

    public void remove(int key) {
        int h = myhash(key);
        Iterator<Pair> it = data[h].iterator();
        while(it.hasNext()){
            Pair element = it.next();
            if(element.getKey() == key) {
                Object o = new Object();
                it.remove();
            }
        }

    }
    public int myhash(int key){
        return key%BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */