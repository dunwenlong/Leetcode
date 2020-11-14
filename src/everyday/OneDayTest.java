package everyday;

import java.util.*;

/**
 * @author Dun Wenlong
 * @time 28/10/2020 下午 2:16
 */
public class OneDayTest {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> records = new HashMap<>();
        for (int i : arr) {
            records.put(i, records.getOrDefault(i, 0) + 1);
        }
        int n = records.size();
        HashSet<Integer> sets = new HashSet<>();
        for (Map.Entry entry : records.entrySet()) {
            sets.add((Integer) entry.getValue());
        }
        return sets.size() == n;
    }

    public String[] permutation(String S) {
        int n = S.length();
        char[] cs = S.toCharArray();
        Arrays.sort(cs);
        ArrayList<String> resList = new ArrayList<String>();
        StringBuilder stb = new StringBuilder();
        boolean[] isUsed = new boolean[n];
        backtrack(cs, n, stb, resList, isUsed);
        int nRes = resList.size();
        String[] res = new String[nRes];
        res = resList.toArray(res);
        return res;
    }

    public void backtrack(char[] cs, int n, StringBuilder stb, ArrayList<String> resList,
                          boolean[] isUsed) {
        if(stb.length() == n){
            resList.add(stb.toString());
            return;
        }
        for(int i = 0; i < n; i++){
            if((i>0 && cs[i]==cs[i-1]) || isUsed[i]){
                continue;
            }
            stb.append(cs[i]);
            isUsed[i] = true;
            backtrack(cs, n, stb,  resList, isUsed);
            isUsed[i] = false;
            stb.deleteCharAt(stb.length()-1);
        }
    }
    public String complexNumberMultiply(String a, String b) {
        String[] va = a.split("/+");
        String[] vb = b.split("/+");
        va[1] = deleteI(va[1]);
        vb[1] = deleteI(vb[1]);
        int[] res = new int[4];
        res[0] = Integer.valueOf(va[0])*Integer.valueOf(vb[0]);
        res[1] = Integer.valueOf(va[0])*Integer.valueOf(vb[1]);
        res[2] = Integer.valueOf(va[1])*Integer.valueOf(vb[0]);
        res[3] = Integer.valueOf(va[1])*Integer.valueOf(vb[1]);
        int resI = res[1]+res[2];
        int resV = res[0]-res[3];
        StringBuilder stb = new StringBuilder();
        stb.append(resV);
        stb.append('+');
        stb.append(resI);
        stb.append('i');
        return stb.toString();
    }
    public String deleteI(String a){
        char[] cs = a.toCharArray();
        return new String(cs, 0,cs.length-1);
    }
    int[] records = new int[1000];
    public int getKth(int lo, int hi, int k) {
        Arrays.fill(records, -1);
        int n = hi-lo;
        Integer[] nums = new Integer[n+1];
        for(int i=lo; i<=hi; i++){
            nums[i-lo] = i;
        }
        Arrays.sort(nums, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getF(o1)-getF(o2);
            }
        });
        return nums[k];
    }

    public int getF(int x){
        if(records[x]!=-1){
            return records[x];
        }
        if(x==1){
            records[x] = 0;
            return 0;
        }
        if(x%2==1){
            records[x] = getF(3*x+1)+1;
            return records[x];
        }else{
            records[x] = getF(x/2)+1;
            return records[x];
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        boolean isPlaced = false;
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] interval: intervals){
            if(interval[0]>newRight){
                if(!isPlaced){
                    res.add(new int[]{newLeft, newRight});
                    isPlaced = true;
                }
                res.add(interval);
            } else if(interval[1]<newLeft){
                res.add(interval);
            } else{
                newLeft = Math.min(newLeft, interval[0]);
                newRight = Math.max(newRight, interval[1]);
            }
        }
        if(!isPlaced){
            res.add(new int[]{newLeft, newRight});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
