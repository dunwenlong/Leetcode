/**
 * @author Dun Wenlong
 * @time 2020/6/18 14:09
 * 面试题 16.03. 交点
 */
public class Intersection {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if(start1[0]>start2[0]){
            swap(start1,end1,start2,end2);
        }
        double[] kb1 = getLine(start1, end1);
        double[] kb2 = getLine(start2, end2);
        if(kb1[0]==kb2[0]){
            if(kb1[0] == kb2[1]){
                if((start1[0]>start2[0]&&start1[0]<end2[0])){

                }
            }
        }
        return new double[]{};
    }

    private void swap(int[] start1, int[] end1, int[] start2, int[] end2) {

    }

    private double[] getLine(int[] start, int[] end) {
        double k = (double) 0.0;
        double b = (double) 0.0;
        if(start[0] == end[0]){
            k = Double.MAX_VALUE;
            b = start[0];
        } else{
            k = (double)(1.0*(start[1]-end[1]))/(start[0]-end[0])+0.0;
            b = start[1] - k*start[0];
        }
        return new double[]{k, b};
    }
}
