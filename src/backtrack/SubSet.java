package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dun Wenlong
 * @time 2020/8/22 17:19
 */
public class SubSet {
    List<List<Integer>> res = new ArrayList<>();
    public void backtrack(int first, Stack<Integer> cur, int[] nums, int n, int k){
        if(cur.size() >= k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=first; i<n; i++){
            if(i > first && nums[i - 1] == nums[i]){
                // (i != start && nums[i - 1] == nums[i])
                continue;
            }
            cur.push(nums[i]);
            backtrack(i+1, cur, nums, n, k);
            cur.pop();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int k = 0; k < n + 1; ++k) {
            backtrack(0, new Stack<Integer>(), nums, n, k);
        }
        return res;
    }
    public static void main(String[] args){
        SubSet subsets = new SubSet();
        int[] nums ={3, 2, 1};
        List<List<Integer>> output = subsets.subsets(nums);
        for(List list: output){
            System.out.println(list);
        }
    }
}
