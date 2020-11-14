package everyday;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dun Wenlong
 * @time 2020/11/9 19:25
 */
public class KthCloest1109 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i=0; i<K; i++){
            int temp = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            pQueue.offer(new int[]{temp, i});
        }
        int n = points.length;
        for(int i=K; i<n; i++){
            int temp = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(temp<pQueue.peek()[0]){
                pQueue.poll();
                pQueue.offer(new int[]{temp, i});
            }
        }
        int[][] res = new int[K][2];
        for(int i=0; i<K; i++){
            res[i] = points[pQueue.poll()[1]];
        }
        return res;
    }
}
