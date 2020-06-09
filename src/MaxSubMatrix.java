
/**
 * @author Admin
 * 最大子矩阵
 */
public class MaxSubMatrix {
    public int[] getMaxMatrix(int[][] matrix){
        int[] pots = new int[4];
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] rowSum = new int[cols];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int tempr = 0, tempc = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                rowSum[j] = 0;
            }
            for(int j=i; j<rows; j++){
                sum=0;
                for(int k=0; k<cols; k++){
                    rowSum[k] += matrix[j][k];
                    if(sum>0){
                        sum += rowSum[k];
                    } else{
                        sum = rowSum[k];
                        tempr = i;
                        tempc = k;
                    }
                    if(sum>maxSum){
                        maxSum = sum;
                        pots[0] = tempr;
                        pots[1] = tempc;
                        pots[2] = j;
                        pots[3] = k;
                    }
                }
            }
        }
        return pots;
    }
    public static void main(String[] args){
        
    }
}
