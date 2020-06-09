import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 46. 全排列
public class Permute {
//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if(len == 0){
//            return res;
//        }
//        LinkedList<Integer> path = new LinkedList<>();
//        boolean[] used = new boolean[len];
//        dfs(nums, len , 0, path, used, res);
//        return res;
//    }
//    private void dfs(int[] nums, int len, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res) {
//        if(depth == len){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i=0; i<len; i++){
//            if(used[i]){
//                continue;
//            }
//            path.addLast(nums[i]);
//            used[i] = true;
//            dfs(nums, len, depth+1, path, used, res);
//            path.removeLast();
//            used[i] = false;
//        }
//    }
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int len = nums.length;
    if(len<1){
        return res;
    }
    Arrays.sort(nums);
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used = new boolean[len];
    dfs(nums, len, 0, path, used, res);
    return res;
}
    public void dfs(int[] nums, int len, int deepth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res){
        if(deepth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<len; i++){
            if(used[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, deepth+1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
