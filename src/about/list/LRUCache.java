package about.list;

import java.util.LinkedHashMap;

/**
 * @author Dun Wenlong
 * @time 2020/7/16 11:23
 * 题目：实现LRU(最近最少使用)缓存机制
 * 思路：1、使用LinkedHashMap存储数据，缺点在于取出移除元素太费时
 * 2、
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return val;
        } else{
            return -1;
        }
    }
    public void put(int key, int value) {
        if (get(key)!=-1){
            cache.put(key, value);
        } else{
            cache.put(key, value);
        }
        if(cache.size()>capacity){
            for(int k : cache.keySet()){
                cache.remove(k);
                if(cache.size()<=capacity){
                    break;
                }
            }
        }
    }
}
