/**
 * @author Dun Wenlong
 * @date 2020/6/18
 * 面试题 16.13. 平分正方形
 */
public class CutSquares {
    public double[] cutSquares(int[] square1, int[] square2) {
        double[] mid1 = getMidSpot(square1);
        double[] mid2 = getMidSpot(square2);
        double k = 0.0;
        double[] res = new double[4];
        if(mid1[0] == mid2[0]){
            res[0] = mid1[0];
            res[2] = mid1[0];
            res[1] = Math.min(square1[1], square2[1]);
            res[3] = Math.max(square1[1]+square1[2], square2[1]+square2[2]);
            return res;
        } else{
            k = (mid2[1]-mid1[1])/(mid2[0]-mid1[0]);
        }
        if(Math.abs(k)<=1.0){
            res[0] = Math.min(square1[0], square2[0]);
            res[2] = Math.max(square1[0]+square1[2], square2[0]+square2[2]);
            res[1] = mid1[1] + k*(res[0]-mid1[0]);
            res[3] = mid1[1] + k*(res[2]-mid1[0]);
            return res;
        } else {
            res[1] = Math.min(square1[1], square2[1]);
            res[3] = Math.max(square1[1] + square1[2], square2[2] + square2[1]);
            res[0] = (res[0] - mid1[1]) / k + mid1[0];
            res[2] = (res[3] - mid1[1]) / k + mid1[0];
            if (res[0] > res[2]) {
                double temp = res[0];
                res[0] = res[2];
                res[2] = temp;
            }
            return res;
        }
    }

    private double[] getMidSpot(int[] square) {
        double[] midSpot = new double[2];
        midSpot[0] = (double)square[0]+square[2]/2.0+0.0;
        midSpot[1] = (double)square[1]+square[2]/2.0+0.0;
        return midSpot;
    }

}
