package everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dun Wenlong
 * @time 2020/11/17 15:46
 */
public class AllCellsDistOrder1117 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R*C][2];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                matrix[i*C+j] = new int[]{i,j};
            }
        }
        Arrays.sort(matrix, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - r0)+Math.abs(o1[1]-c0)-Math.abs(o2[0]-r0)-Math.abs(o2[1]-c0);
            }
        });
        return matrix;
    }
}
