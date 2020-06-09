import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node, Node> copyMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node res = new Node(head.val);
        copyMap.put(head, res);
        Node tempR = res;
        Node tempH = head;
        while (tempH.next!=null){
            tempR.next = new Node(tempH.next.val);
            tempR = tempR.next;
            tempH = tempH.next;
            copyMap.put(tempH, tempR);
        }
        tempH = head;
        tempR = res;
        while (tempH!=null){
            if(tempH.random!=null){
                tempR.random = copyMap.get(tempH.random);
            }
            tempH = tempH.next;
            tempR = tempR.next;
        }
        return res;
    }
}
