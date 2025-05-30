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
import java.util.Map;

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

class LRUCache20240618 {
    int cap = 0;
    Map<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache20240618(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            makeRecent(key);
            return cache.get(key);
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            makeRecent(key);
            cache.put(key,value);
            return;
        }

        if(cap == cache.size()){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
            //cache.put(key,value);
        }
        cache.put(key,value);
    }
    private void makeRecent(int key){
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

    //记忆很深刻，关键是需要借助LinkedHashMap的帮助
    //还要记住LinkedHashMap插入时是尾插，所以最旧的节点在头部

class LRUCache20240723 {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;
    public LRUCache20240723(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            makeRecent(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        if(cache.size()>=capacity){
            int oldestKey = cache.keySet().iterator().next();
            // int oldestValue = cache.get(oldestKey);
            cache.remove(oldestKey);
            cache.put(key, value);
            return;
        }
        cache.put(key, value);
        return;
    }
    private void makeRecent(int key){
        //int oldestKey = cache.keySet().iterator.hasNext();
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }
}

//还行，半小时内做出来的吧，只是忘了int oldestKey = cache.keySet().iterator().next()的写法，
//以及忘了在key已存在时更新value

    class LRUCache20241204 {
        private LinkedHashMap<Integer, Integer> cache;
        private int cap;
        public LRUCache20241204(int capacity) {
            cap = capacity;
            cache = new LinkedHashMap<Integer,Integer>();
        }

        public int get(int key) {
            //取完要调整为最近使用
            if(cache.containsKey(key)){
                makeRecent(key);
                return cache.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            //1.已存在，需要放完再调整为最近使用。2.已满，需删除LRU，再放3.不存在也没满，直接放
            if(cache.containsKey(key)){
                cache.put(key,value);
                makeRecent(key);
                return;
            }
            if(cache.size()==cap){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
                cache.put(key,value);
                return;
            }
            cache.put(key,value);
        }
        public void makeRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }
    }
//需要知道，每次取或者放，都会造成key是最近被使用过
    class LRUCache20250517 {
        private int cap;
        private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache20250517(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            mackRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                cache.put(key,value);
                mackRecently(key);
                return;
            }
            if(cache.size()>=cap){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key,value);
        }

        public void mackRecently(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }
    }

    class LRUCache20250517v2 {
        private int cap;
        private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache20250517v2(int capacity) {
            cap = capacity;
        }

        public void makeRecently(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }

        public int get(int key) {
            if(!cache.containsKey(key)){
                return -1;
            }
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                cache.put(key,value);
                makeRecently(key);
                return;
            }
            if(cache.size()>=cap){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }
    }

    class LRUCache20250520 {

        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap;
        public LRUCache20250520(int capacity) {
            cap = capacity;
        }

        public void mackRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                mackRecent(key);
                return cache.get(key);
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                mackRecent(key);
                cache.put(key,value);
                return;
            }
            if(cache.size()>=cap){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            //put要写到if外面
            cache.put(key, value);
        }
    }

    class LRUCache20250524 {
        int cap = 0;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache20250524(int capacity) {
            cap = capacity;
        }
        public void mackRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key,value);
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
                mackRecent(key);
                cache.put(key,value);
                return ;
            }
            if(cache.size()>=cap){
                //看了labuladong知道了，链表头部元素，就是最久没使用的，也就是，链表采用的是尾插法
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key,value);
        }
    }

    class LRUCache20250530 {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache20250530(int capacity) {
            cap = capacity;
        }

        public void makeRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                makeRecent(key);
                return cache.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                makeRecent(key);
                cache.put(key,value);
                return;
            }
            if(cap<=cache.size()){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            //makeRecent(key);
            //链表采用的是尾插法，所以尾部是最新的，这里不用mackRecent
            cache.put(key,value);
        }
    }
}