import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 */
public class SubarraysDivByK {
//    public static int subarraysDivByK(int[] A, int K) {
//        Map<Integer, Integer> record = new HashMap<>();
//        record.put(0,1);
//        int count = 0;
//        int preSum = 0;
//        for(int i=0; i<A.length; i++){
//            preSum = ((preSum+A[i])%K+K)%K;
//            if(record.containsKey(preSum)){
//                count += record.get(preSum);
//            }
//            record.put(preSum, record.getOrDefault(preSum, 0)+1);
//        }
//        return count;
//    }
    public static void main(String[] args){
        int[] test = {4,5,0,-2,-3,1};
        System.out.println(SubarraysDivByK.subarraysDivByK(test, 5));
    }
//    不用hashmap
        public static int subarraysDivByK(int[] A, int K) {
        int[] record = new int[K];
        record[0] = 1;
        int count = 0;
        int preSum = 0;
        for(int i=0; i<A.length; i++){
            preSum = ((preSum+A[i])%K+K)%K;
            if(record[preSum]!=0){
                count += record[preSum];
            }
            record[preSum] += 1;
        }
        return count;
    }
}
