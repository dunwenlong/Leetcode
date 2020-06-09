import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

// 示例 1 :

// 输入:nums = [1,1,1], k = 2
// 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 说明 :

// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class SubarraySum {
    static class Solution {
        //暴力法
        // public int subarraySum(int[] nums, int k) {
        //     int ans = 0;
        //     int n = nums.length;
        //     int temp = 0;
        //     for(int i = 0; i<n; i++){
        //         for(int j = i; j<n;){
        //             temp = temp + nums[j];
        //             if( temp == k){
        //                 ans++;
        //             }
    
        //         }
        //     }
        //     return ans;
        // }
        //利用前缀和求连续数组的和，使用hash表记录前缀和，如果当前前缀和与目标值的差值
        //在hash表中出现，则说明存在连续数组的和为目标值
        public int subarraySum(int[] nums, int k){
            int ans = 0;
            Map<Integer, Integer> preSumMap = new HashMap<>();
            preSumMap.put(0, 1);

            int preSum = 0;
            for(int num:nums){
                preSum+=num;
                if(preSumMap.containsKey(preSum-k)){
                    ans += preSumMap.get(preSum-k);
                }
                if(preSumMap.containsKey(preSum)){
                    preSumMap.put(preSum, preSumMap.get(preSum)+1);
                } else{
                    preSumMap.put(preSum, 1);
                }
            }
            return ans;
        }
    }
}