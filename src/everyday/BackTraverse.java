package everyday;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dun Wenlong
 * @time 2020/9/29 8:45
 */
public class BackTraverse {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            res.add(tempNode.val);
            if(tempNode.left != null){
                stack.push(tempNode.left);
            }
            if(tempNode.right != null){
                stack.push(tempNode.right);
            }
        }
        int n = res.size();
        List<Integer> rres = new ArrayList<>(n);
        for(int i = n-1; i >=0 ; i--){
            rres.add(res.get(i));
        }
        return rres;
    }
}
