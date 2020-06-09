import java.util.LinkedList;
import java.util.List;

public class BSTsequences {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            res.add(new LinkedList<>());
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);

        helper(root, new LinkedList<>(), path);
        return res;
    }

    private void helper(TreeNode root, LinkedList<TreeNode> queue, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            queue.addLast(root.left);
        }
        if (root.right != null) {
            queue.addLast(root.right);
        }
        int lens = queue.size();
        for (int i = 0; i < lens; i++) {
            TreeNode cur = queue.get(i);
            queue.remove(i);
            path.add(cur.val);

            helper(cur, new LinkedList<>(queue), path);

            queue.add(i, cur);
            path.removeLast();
        }
    }
}
