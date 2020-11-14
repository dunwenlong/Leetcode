package everyday;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Dun Wenlong
 * @time 2020/11/14 9:03
 */
public class RelativeSortArray1114 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] records = new int[1001];
        for(int num:arr1){
            records[num] += 1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int num:arr2){
            while(records[num]>0){
                res.add(num);
                records[num] -= 1;
            }
        }
        for(int i=0; i<1001; i++){
            while(records[i]>0){
                res.add(i);
                records[i] -= 1;
            }
        }
        int[] resNums = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            resNums[i] = res.get(i);
        }
        return resNums;
    }
}
