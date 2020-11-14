package everyday;

import java.util.HashMap;

/**
 * @author Dun Wenlong
 * @time 2020/10/3 18:04
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> records = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];
        for(int i=0; i<n; i++){
            if(records.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = records.get(target-nums[i]);
                return res;
            }
            records.put(nums[i], i);
        }
        return res;
    }
}
