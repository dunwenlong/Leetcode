package huawei;

/**
 * @author Dun Wenlong
 * @time 2020/8/20 16:44
 */
public class PrintMatrix {
    public static int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows < 1) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int l = 0, r = cols - 1, t = 0, b = rows - 1;
        int cnt = 0;
        while (true) {
            for(int i=l; l<=r; i++){
                res[cnt] = matrix[t][i];
                cnt++;
            }
            if(++t>b){
                break;
            }
            for(int i=t; i<=b; i++){
                res[cnt] = matrix[i][r];
                cnt++;
            }
            if(--r<l){
                break;
            }
            for(int i=r; i>=l; i--){
                res[cnt] = matrix[b][i];
            }
            if(--b<t){
                break;
            }
            for(int i=b; i>= t; i--){
                res[cnt] = matrix[i][l];
                cnt++;
            }
            if(++l>r){
                break;
            }
        }
        return res;
    }
}
