package everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dun Wenlong
 * @time 2020/11/12 12:40
 */
public class PairSums1112 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> records = new HashMap<>();
        for(int num: nums){
            records.put(num, records.getOrDefault(num, 0) +1);
        }
        for(Map.Entry<Integer, Integer> entry: records.entrySet()){
            while(entry.getValue()>0){
                int temp = entry.getKey();
                records.put(temp, records.get(temp)-1);
                if(records.containsKey(target-temp) && records.get(target-temp)>0){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(temp);
                    tempList.add(target-temp);
                    res.add(tempList);
                    records.put(target-temp, records.get(target-temp)-1);
                } else{
                    break;
                }
            }
        }
        return res;
    }
}
