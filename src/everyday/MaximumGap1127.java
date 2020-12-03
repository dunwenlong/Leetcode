package everyday;

import java.util.Arrays;

/**
* @author Dun Wenlong 
* @time  2020/11/27 20:23  
*/
public class MaximumGap1127 {
    public int maximumGap(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int minNUM = Integer.MAX_VALUE;
        int n = nums.length;
        if(n<2){
            return 0;
        }
        for(int i=0; i<n; i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }
            if(minNUM > nums[i]){
                minNUM = nums[i];
            }
        }
        int d = Math.max((maxNum - minNUM)/(n-1), 1);
        int bucketSize = (maxNum - minNUM)/d+1;
        int[][] buckets = new int[bucketSize][2];
        for(int i=0; i<bucketSize; i++){
            Arrays.fill(buckets[i], Integer.MIN_VALUE);
        }
        for(int i=0; i<n; i++){
            int index = (nums[i]-minNUM)/d;
            if(buckets[index][0] == Integer.MIN_VALUE){
                Arrays.fill(buckets[index], nums[i]);
                continue;
            }
            if(nums[i]<buckets[index][0]) {
                buckets[index][0] = nums[i];
            }
            if(nums[i]>buckets[index][1]){
                buckets[index][1] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        int prev = -1;
        for(int i=0; i<bucketSize; i++){
            if(buckets[i][0]==Integer.MIN_VALUE){
                continue;
            }
            if(prev !=-1){
                if(buckets[i][0]-buckets[prev][1]>res){
                    res = buckets[i][0]-buckets[prev][1];
                }
            }
            prev = i;
        }
        return res;
    }
    public static void main(String[] args){
        MaximumGap1127 maximumGap = new MaximumGap1127();
        System.out.println(maximumGap.maximumGap(new int[]{1,1,1,1}));
    }
}
