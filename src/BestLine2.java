/**
 * @author Dun Wenlong
 * @date 2020/6/12
 */

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BestLine2 {
    public static void main(String[] args) {
        BestLine2 bestLine = new BestLine2();
        int[][] points = {{-38935, 27124}, {-39837, 19604}, {-7086, 42194}, {-11571, -23257}, {115, -23257}, {20229, 5976}, {24653, -18488}, {11017, 21043}, {-9353, 16550}, {-47076, 15237}, {-36686, 42194}, {-17704, 1104}, {31067, 7368}, {-20882, 42194}, {-19107, -10597}, {-14898, 24506}, {-20801, 42194}, {-52268, 40727}, {-14042, 42194}, {-23254, 42194}, {-30837, -53882}, {1402, 801}, {-33961, -984}, {-6411, 42194}, {-12210, 22901}, {-8213, -19441}, {-26939, 20810}, {30656, -23257}, {-27195, 21649}, {-33780, 2717}, {23617, 27018}, {12266, 3608}};
//        int[][] points = {{0,0},{1,1},{1,0},{2,0}};
//        int[][] points = {{-13260,8589},{1350,8721},{-37222,-19547},{-54293,-29302},{-10489,-13241},{-19382,574},{5561,1033},{-22508,-13241},{-1542,20695},{9277,2820},{-32081,16145},{-50902,23701},{-8636,19504},{-17042,-28765},{-27132,-24156},{-48323,-4607},{30279,29922}};
        int[] res = bestLine.bestLine(points);
        for (int i : res) {
            System.out.println(i);
        }
//        System.out.println(bestLine.MaxGCD(24, 10));
    }

    //思路：建立一个hash表，键为直线，值为直线上的点的个数，最小的两个编号
//    private class Line{
//        public double k;
//        public double b;
//        Line(double k, double b){
//            this.k = k;
//            this.b = b;
//        }
//        public boolean equals(Line l2){
//            if(l2.k == this.k && l2.b ==this.b){
//                return true;
//            } else{
//                return false;
//            }
//        }
//    }
    private double getKB(int  [] point1, int  [] point2) {
        if (point1[0] == point2[0]) {
            double res = Double.MAX_VALUE;
            return res;
        }
        double res = 1.0 * (point1[1] - point2[1]) / (point1[0] - point2[0]) + 0.0;
        return res;
    }

    private int[] getAB(int[] point1, int[] point2) {
        int A = point2[1] - point1[1];
        int B = point1[0] - point2[0];
        int maxGCD = MaxGCD(A, B);
        A = A / maxGCD;
        B = B / maxGCD;
        return new int[]{A, B};
    }

    public int[] bestLine(int[] @NotNull [] points) {
        int maxCount = 0;
        int[] res = new int[2];
        int lenPoints = points.length;
        Map<Double, Integer> recordCount = new HashMap<>();
        Map<Double, int[]> recordPoint = new HashMap<>();
        for (int i = 0; i < lenPoints; i++) {
            recordCount.clear();
            recordCount.clear();
            for (int j = i+1; j < lenPoints; j++) {
                double kb = getKB(points[i], points[j]);
                if (recordCount.containsKey(kb)) {
                    recordCount.put(kb, recordCount.get(kb) + 1);
                } else {
                    recordCount.put(kb, 1);
                    int[] point = new int[2];
                    point[0] = i;
                    point[1] = j;
                    recordPoint.put(kb, point);
                }
                int[] tempRes = recordPoint.get(kb);
                if (recordCount.get(kb) > maxCount || (recordCount.get(kb) == maxCount && tempRes[0] < res[0]) ||
                        (recordCount.get(kb) == maxCount && tempRes[0] == res[0] && tempRes[1] < res[1])) {
                    maxCount = recordCount.get(kb);
                    res[0] = tempRes[0];
                    res[1] = tempRes[1];
                }
            }
        }
        return res;
    }

    public int MaxGCD(int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = x;
        }
        int z = y;
        while (x % y != 0) {
            z = x % y;
            x = y;
            y = z;
        }
        return y;
    }
}