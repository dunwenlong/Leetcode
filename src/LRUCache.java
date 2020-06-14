import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dun Wenlong
 */
public class LRUCache {
    private class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveTotail(node);

        return node.val;
    }

    private void moveTotail(ListNode node) {
        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
    }

    public void put(int key, int value) {
        if(get(key)!=-1){
            map.get(key).val = value;
            return;
        }
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        moveTotail(node);
        if(map.size()>capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }
}
