/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : LC146_lru_cache
 * Date Created : 2024-02-27
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-02-27       Admin     xxx
 * --------------------------------------------------------------------
 */

import java.util.LinkedHashMap;

/**
 * @program: PACKAGE_NAME
 * @description: xxx
 * 感觉这题还挺有意思的，记一下吧
 * 20240320第二次做，这里踩坑了，这里要用else if，不能再if，比如容量2，插入第二组时，上面插入完了，下面这个if会误删一组数据，我真是靠北了
 * @author: Admin
 * @create: 2024-02-27
 **/
public class LC146_lru_cache {

    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;

        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            /*int val = cache.get(key);
            cache.remove(key);
            cache.put(key,val);*/
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {

            if(cache.containsKey(key)){
                cache.put(key,value);
                makeRecently(key);
                return;
            }
            //记住缓存队列是固定容量，满了就要删最不常用的
            if(cache.size()>=this.cap){
                //缓存队列头部是最老的
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key,value);
        }
        private void makeRecently(int key){
            int val = cache.get(key);
            cache.remove(key);
            //放到队尾，队尾是最常用的
            cache.put(key,val);
        }
    }

    class LRUCache20240320 {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int size;

        public LRUCache20240320(int capacity) {
            this.size = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            mackRecent(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                //cache.put(key, value);
                mackRecent(key);
                //return;
                //cache.put(key, value);
                //第二次做，这里踩坑了，这里要用else if，不能再if，比如容量2，插入第二组时，上面插入完了，下面这个if会误删一组数据，我真是靠北了
            }else if(cache.size()==this.size){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
                //cache.put(key, value);
            }
            cache.put(key, value);
        }
        public void mackRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
        }
    }

    //浏览了一遍labuladong，才回忆起一点点，关键是借助linkedHashMap实现
    class LRUCache20240613 {
        private int cap;
        private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache20240613(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)){
                makeRecent(key);
                return cache.get(key);
            }
            //没有怎么办，按题意返回-1
            return -1;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                makeRecent(key);
            }
            //不存在则插入，插入前判断容量是否够，不够就删除最少使用的元素
            //一遍遍踩坑，靠北了我真是，这里不用else而直接用if的话，如果cache已满，且上面get完了，还会走下面这个，会remove头上的元素！
            else if(cap==cache.size()){
                //最久未使用的元素怎么取到？
                //看了labuladong知道了，链表头部元素，就是最久没使用的，也就是，链表采用的是尾插法
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key,value);
        }
        public  void makeRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}