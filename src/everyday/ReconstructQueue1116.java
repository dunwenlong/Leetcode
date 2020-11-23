package everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Dun Wenlong
 * @time 2020/11/16 9:56
 */
public class ReconstructQueue1116 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                } else{
                    return o2[0]-o1[0];
                }
            }
        });
        LinkedList<int[]> list = new LinkedList<int[]>();
        for(int[] p:people){
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
