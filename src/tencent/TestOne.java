package tencent;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Dun Wenlong
 * @time 2020/8/20 9:28
 */
public class TestOne {
    int minRes = Integer.MAX_VALUE;
    int[] w = {3, 2, 1, 0};
    public int minMain(int n, int m, int[] a){
        int[] x = new int[m];
        dfs(w, a, x, 0, 0, n, m, 0, minRes);
        return minRes;
    }

    private void dfs(int[] w, int[] a, int[] x, int i, int j, int n, int m, int cRes, int minRes) {
        if(j>=n){
            if(i<=m){
                minRes = Math.min(minRes, cRes);
            }
        } else{
            for(int jj = 0; jj<4; jj++){
                x[i] = jj;
                if(j+x[i]<n){
                    j+= x[i];
                    cRes += w[x[i]]*(a[x[i]])/3;
                    dfs(w, a, x, i+1,j,n,m, cRes, minRes);
                    j-=x[i];
                    cRes -= w[x[i]]*(a[x[i]])/3;
                }
            }
        }
    }
    private void addNode(Stack<Integer> path, int[] w){
        for(int i=0; i<4; i++){
            path.add(w[i]);
        }
    }
}
