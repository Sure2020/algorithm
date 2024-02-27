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
}