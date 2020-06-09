import javax.swing.tree.TreeNode;
import java.util.*;

public class Helloworld {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static void main(String[] args){
//        System.out.println("hello, world");
//        System.out.println(Helloworld.reverseLeftWords("abcdefg", 2));
        int[] nums = {3, 3, 4};
        System.out.println(Helloworld.majorityElement(nums));
    }
    public static String reverseLeftWords(String s, int n) {
        String subStr = s.substring(0,n);
        String temp = s.replace(subStr, "");
        final String concat = temp.concat(subStr);
        return concat;
    }
    static List<Integer> arr = new ArrayList<Integer>();
    public static int kthLargest(TreeNode root, int K){
        dfs(root);
        return arr.get(K);
    }
    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        arr.add(root.val);
        dfs(root.left);
    }
//    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//    public List<List<Integer>> levelOrder(TreeNode root){
//        List<List<Integer>> resList = new ArrayList<List<Integer>>();
//        if(root == null){
//            return resList;
//        }
//        queue.addLast(root);
//        while (!queue.isEmpty()) {
//            ArrayList<Integer> tempList = new ArrayList<>();
//            LinkedList<TreeNode> tempQueue = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                TreeNode tempNode = queue.removeFirst();
//                tempList.add(tempNode.val);
//                if (TreeNode.left != null) {
//                    tempQueue.addLast(TreeNode.left);
//                }
//                if (TreeNode.right != null) {
//                    tempQueue.addLast(TreeNode.right);
//                }
//            }
//            queue = tempQueue;
//            resList.add(tempList);
//        }
//    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> record= new HashMap<Integer, Integer>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
            record.put(nums[i], record.getOrDefault(nums[i], 0)+1);
            if(record.get(nums[i])>=nums.length/2.0){
                res = nums[i];
            }
        }
        return res;
    }
}
