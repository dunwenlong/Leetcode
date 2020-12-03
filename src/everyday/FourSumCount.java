package everyday;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Dun Wenlong
 * @time 2020/11/27 21:19
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n  = A.length;
        int[] ab = new int[n*n];
        HashMap<Integer, Integer> cbMap = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ab[i*n+j] = A[i]+B[j];
                cbMap.put(C[i]+D[j], cbMap.getOrDefault(C[i]+D[j], 0)+1);
            }
        }
        int res = 0;
        for(int i=0; i<n*n; i++){
            if(cbMap.containsKey(-ab[i])){
                res += cbMap.get(-ab[i]);
            }
        }
        return res;
    }
}
