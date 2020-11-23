package everyday;

import tree.TreeNode;

import java.util.*;

/**
 * @author Dun Wenlong
 * @time 2020/11/19 19:14
 */
public class ZigzagLevelOrder1119 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        boolean isZ = true;
        while (!queue.isEmpty()){
            ArrayList<Integer> tempList = new ArrayList<>();
            int n = queue.size();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                tempList.add(node.val);
            }
            if(isZ){
                Collections.reverse(tempList);
            }
            res.add(tempList);
        }
        return res;
    }
}
