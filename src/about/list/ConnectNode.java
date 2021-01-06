//package about.list;
//
//import org.w3c.dom.Node;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @author Dun Wenlong
// * @time 2020/9/28 8:55
// */
//public class ConnectNode {
//    public Node connect(Node root) {
//        Queue<Node> helpQueue = new LinkedList<Node>();
//        if(root == null){
//            return root;
//        }
//        helpQueue.add(root);
//        while(!helpQueue.isEmpty()){
//            int n = helpQueue.size();
//            Node pre = helpQueue.poll();
//            if(pre.left!=null){
//                helpQueue.offer(pre.left);
//            }
//            if(pre.right!=null){
//                helpQueue.offer(pre.right);
//            }
//            for(int i=1; i<n; i++){
//                Node curNode = helpQueue.poll();
//                pre.next = curNode;
//                pre = pre.next;
//                if(curNode.left!=null){
//                    helpQueue.offer(curNode.left);
//                }
//                if(curNode.right!=null){
//                    helpQueue.offer(curNode.right);
//                }
//            }
//        }
//        return root;
//    }
//}
