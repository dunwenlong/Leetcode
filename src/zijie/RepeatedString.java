package zijie;

import java.util.HashSet;

/**
 * @author Dun Wenlong
 * @time 2020/9/1 21:03
 */
public class RepeatedString {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> records = new HashSet<>();
        if(s == null){
            return 0;
        }
        int lenS = s.length();
        if(lenS<2){
            return lenS;
        }
        char[] cs = s.toCharArray();
        records.add(cs[0]);
        int l = 0;
        int r = 1;
        int res = 0;
        while(r<lenS){
            if(!records.contains(cs[r])){
                res = Math.max(res, r-l+1);
                records.add(cs[r]);
            } else{
                while(records.contains(cs[r])&&l<r){
                    records.remove(cs[l]);
                    l++;
                }
                continue;
            }
            r++;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
