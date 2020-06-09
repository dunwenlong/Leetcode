import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
// 错误
class LRUCache2 {
    private int capacity;
    private Map<Integer, Integer>  map;
    private LinkedList<Integer> list;
    public LRUCache2(int capacity){
      this.capacity = capacity;
      map = new HashMap<>();
      list = new LinkedList<>();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int indexOfValue = map.get(key);
        int tempVal = list.get(indexOfValue);
        list.remove(indexOfValue);
        list.addLast(tempVal);
        for(int tempkey:map.keySet()){
            map.put(tempkey, map.get(key)-1);
        }
        map.remove(key);
        map.put(key, list.size()-1);
        return tempVal;
    }
    public void put(int key, int value){
        if(get(key)!=-1){
            list.removeLast();
            list.addLast(value);
            return;
        }
        //不存在
        list.addLast(value);
        map.put(key, list.size()-1);
        if(map.size()>capacity){
            map.remove(key);
            list.removeFirst();
        }
    }
    public static void main(String[] args){
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        // 返回  1
        cache.put(3, 3);
        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        // 返回 -1 (未找到)
        cache.put(4, 4);
        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        // 返回  3

        // 返回  4
        System.out.println(cache.get(4));
    }
}
