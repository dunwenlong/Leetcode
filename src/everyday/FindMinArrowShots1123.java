package everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dun Wenlong
 * @time 2020/11/23 13:25
 */
public class FindMinArrowShots1123 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override public int compare(int[] point1, int[] point2) {
                if(point1[0] == point2[0]){
                    return point1[1]-point2[1];
                } else{
                    return point1[0]-point2[0];
                }
            }
        });
        int[] range = {points[0][0], points[0][1]};
        int res = 1;
        for(int i=1; i<points.length; i++){
            if(points[i][0]<=range[1]){
                range[0] = points[i][0];
            } else{
                res++;
                range[0] = points[i][0];
                range[1] = points[i][1];
            }
        }
        return res;
    }
}
