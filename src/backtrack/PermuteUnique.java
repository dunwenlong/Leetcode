package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dun Wenlong
 * @time 2020/8/21 19:49
 * 全排列问题
 */
public class PermuteUnique {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<1) {
            return res;
        }
        Stack<Integer> path = new Stack<>();
        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        backtrack(res, nums, 0, len, path, isUsed);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i, int len, Stack<Integer> path, boolean[] isUsed) {
        if(i == len){
            res.add(new ArrayList<>(path));
        }
        for(int j=0; j<len; j++){
            if(isUsed[j]){
                continue;
            }
            path.push(nums[j]);
            isUsed[j] = true;
            backtrack(res, nums, i+1, len, path, isUsed);
            isUsed[j] = false;
            path.pop();
        }
        /*
        * 如果数组里面有重复元素时，首先将数组排序，然后更改判定条件
        * if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        * continue;
        *  }
        * */
    }
}
