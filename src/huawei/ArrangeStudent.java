package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/26 15:30
 */
public class ArrangeStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] student = new int[N];
            for (int i = 0; i < N; i++) {
                student[i] = sc.nextInt();
            }
            System.out.println(getResult(student));
        }
    }

    public static int getResult(int[] student) {
        int N = student.length;
        if (N < 1) {
            return 0;
        }
        // maxInc[i]表示以student[i]结尾的最长递增子数组的大小
        int[] maxInc = new int[N];
        // maxDec[i]表示以student[i]开头的最长递减子数组的大小
        int[] maxDec = new int[N];
        for (int i = 0; i < N; i++) {
            maxInc[i] = 1;
            maxDec[i] = 1;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(student[i]>student[j] && maxInc[j]+1>maxInc[i]){
                    maxInc[i] = maxInc[j]+1;
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(student[j]<student[i] && maxDec[j]+1>maxDec[i]){
                    maxDec[i] = maxDec[j]+1;
                }
            }
        }
        int maxRes = -1;
        for(int i=0; i<N; i++){
            if(maxRes<maxDec[i]+maxInc[i]){
                maxRes = maxDec[i]+maxInc[i];
            }
        }
        return N-maxRes+1;
    }
}
