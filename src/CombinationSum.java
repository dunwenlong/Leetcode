import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, len , target,0,0, res, path);
        return res;
    }
    private static void dfs(int[] nums, int len, int target, int sum, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        for(int i= index; i<len; i++){
            if(nums[i]+sum == target){ ;
                List<Integer> temp = new LinkedList<>(path);
                temp.add(nums[i]);
                res.add(temp);
                return;
            } else if(nums[i]+sum > target){
                return;
            } else{
                path.addLast(nums[i]);
                dfs(nums, len, target, sum+nums[i], i, res, path);
                path.removeLast();
            }
        }
    }
    public static void main(String[] args){
        int[] nums = {2, 3, 4, 7};
        List<List<Integer>> res = CombinationSum.combinationSum(nums, 7);
    }
}
