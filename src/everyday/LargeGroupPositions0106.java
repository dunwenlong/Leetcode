package everyday;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions0106 {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] cs = s.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        char cur = cs[0];
        int cnt = 1;
        for(int i=1; i<cs.length; i++){
            if(cs[i] == cur){
                cnt++;
            } else{
                if(cnt>=3){
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(start);
                    tempList.add(start+cnt-1);
                    res.add(tempList);
                }
                start = i;
                cnt = 1;
                cur = cs[i];
            }
        }
        if(cnt>=3){
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(start);
            tempList.add(start+cnt);
            res.add(tempList);
        }
        return res;
    }
    public static void main(String[] args){
        LargeGroupPositions0106 test = new LargeGroupPositions0106();
        System.out.println(test.largeGroupPositions("abbxxxxzzy"));
    }
}
