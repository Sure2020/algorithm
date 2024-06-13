import java.util.LinkedHashMap;
import java.util.Map;

public class LCR031_OrIXps {
    class LRUCache {
        private int cap;
        private Map<Integer, Integer> cache = new LinkedHashMap<>();
        public LRUCache(int capacity) {
            this.cap = capacity;
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
            if(cache.size()>=cap){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }
        public void makeRecent(int key){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
