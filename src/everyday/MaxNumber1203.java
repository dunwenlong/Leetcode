package everyday;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Dun Wenlong
 * @time 2020/12/3 9:13
 */
public class MaxNumber1203 {
    public boolean wordPattern(String pattern, String s) {
        char[] cs = pattern.toCharArray();
        ArrayList<Integer> []records = new ArrayList[26];
        String[] str_list = s.split(" ");
        int n = cs.length;
        for(int i=0; i<26; i++){
            records[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            records[cs[i]-'a'].add(i);
        }
        for(int i=0; i<26; i++){
            for(int j=1; j<records[i].size(); j++){
                if(records[i].isEmpty()){
                    continue;
                }
                int a = records[i].get(j-1);
                int b = records[i].get(j);
                String s1 = str_list[a];
                String s2 = str_list[b];
                if(s1 != null && s2 != null){
                    if(!s1.equals(s2)){
                        return false;
                    }
                } else{
                    if(s1 == null && s2 == null){
                        continue;
                    } else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        MaxNumber1203 maxNumber1203 = new MaxNumber1203();
        System.out.println(maxNumber1203.wordPattern("abba", "dog cat cat dog"));
    }
}
