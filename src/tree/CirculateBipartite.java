package tree;

import java.util.Arrays;

/**
 * @author Dun Wenlong
 * @time 2020/7/16 10:23
 * 785. 判读二分图
 * 题目：给定一个无向图graph，当这个图为二分图时返回true。如果我们能将一个图的节点集合分割成两个独立的子集A和B，
 * 并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * 思路： 任选一个节点将其标记为红色，然后使用深度优先遍历的方法，从该节点开始对无向图进行遍历，假定该节点的相邻节点为u,那么
 * u有2种情况，如果u未被染色，那么u染为绿色，从u节点继续深度优先遍历，如果u被染色，那么判断是否为要染的颜色，如果不是，则说明
 * 给定的无向图不是二分图，我们可以推出遍历，并返回false作为答案。
 */
public class CirculateBipartite {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipatite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        valid = true;
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    private void dfs(int i, int c, int[][] graph) {
        color[i] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[i]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] == cNei) {
                valid = false;
                return;
            }
        }
    }
}
