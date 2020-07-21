package about.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dun Wenlong
 * @time 2020/7/12 9:24
 */
public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length<1){
            return res;
        }
        int len = nums.length;
        LinkedList<Integer> sorted = new LinkedList<>();
        for(int i = len -1; i>-1; i--){
            int pos = binarySearch(sorted, nums[i]);
            sorted.add(pos, nums[i]);
            res.add(pos);
        }
        Collections.reverse(res);
        return res;
    }
    private int binarySearch(LinkedList<Integer> sorted, int target){
        if(sorted.size()<1){
            return 0;
        }
        int l = 0;
        int r = sorted.size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(sorted.get(mid)>=target){
                r = mid -1;
                if(sorted.get(mid)==target){
                    l = r;
                }
            } else{
                l = mid+1;
            }
        }
        return r+1;
    }
    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        int[] nums = {5, 2, 6, 0};
        for(int num: countSmaller.countSmaller(nums)){
            System.out.println(num);
        }
    }
}
