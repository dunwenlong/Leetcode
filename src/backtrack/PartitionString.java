package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dun Wenlong
 * @time 2020/9/30 11:14
 */
public class PartitionString {
    public List<List<String>> partition(String s) {
        char[] cs = s.toCharArray();
        List<List<String>> res = new ArrayList<>();
        backtrack(cs, 0, new ArrayList<String>(), res);
        return res;
    }
    public void backtrack(char[] cs, int start, ArrayList<String> path, List<List<String>> res) {
        if(start>=cs.length){
            res.add(new ArrayList<String>(path));
        }
        for(int i=start; i<cs.length; i++){
            if(isPalindrome(cs, start, i)){
                path.add(newMyString(cs, start, i));
            } else{
                continue;
            }
            backtrack(cs, i+1, path, res);
            path.remove(path.size()-1);
        }
    }

    public boolean isPalindrome(char[] cs, int l, int r) {
        while(l<=r){
            if(cs[l] != cs[r]){
                return false;
            } else{
                l++;
                r--;
            }
        }
        return true;
    }
    public String newMyString(char[] cs, int l, int r){
        StringBuilder stb = new StringBuilder();
        for(int i=l; i<=r; i++){
            stb.append(cs[i]);
        }
        return stb.toString();
    }
}
