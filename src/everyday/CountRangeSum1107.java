package everyday;

/**
 * @author Dun Wenlong
 * @time 2020/11/7 21:05
 */
public class CountRangeSum1107 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int cnt = 0;
        long[] preSum = new long[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
//        nums[0] = preSum[1] - preSum[0];
//        nums[0]+nums[1] = preSum[2]-preSum[0]
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                long temp = preSum[j+1]-preSum[i];
                if(temp>=lower && temp<=upper){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
