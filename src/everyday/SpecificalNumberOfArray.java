package everyday;

import java.util.Arrays;

/**
 * @author Dun Wenlong
 * @time 2020/10/6 11:15
 */
public class SpecificalNumberOfArray {
    public int specialArray(int[] nums) {
        int n = nums.length;
        if(n<1){
            return 0;
        }
        int[] res = new int[n];
        Arrays.sort(nums);
        for(int i=1; i<=n; i++){
            int temp = Arrays.binarySearch(nums, i);
            if(temp>0){
                res[i-1] = n-temp;
            } else{
                res[i-1] = n-(-temp-1);
            }
        }
        for(int i=0; i<n; i++){
            if(res[i]==i+1){
                return i+1;
            }
        }
        return -1;
    }
}
