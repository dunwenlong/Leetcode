package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dun Wenlong
 * @time 2020/8/21 19:24
 */
public class MinDeepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> path = new LinkedList<TreeNode>();
        path.offer(root);
        int res = 0;
        while(!path.isEmpty()){
            Queue<TreeNode> tempPath = new LinkedList<TreeNode>();
            res++;
            while(!path.isEmpty()){
                TreeNode tempNode = path.poll();
                if(tempNode.left == null && tempNode.right == null){
                    return res;
                }
                if(tempNode.left != null){
                    tempPath.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    tempPath.offer(tempNode.right);
                }
            }
            path = tempPath;
        }
        return res;
    }
}
