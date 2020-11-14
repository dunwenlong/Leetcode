package zijie;

/**
 * @author Dun Wenlong
 * @time 2020/9/2 9:57
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len<2){
            return "";
        }
        String res = strs[0];
        for(int i=1; i<len; i++){
            res = inLongestCommonPrefix(res, strs[i]);
            if(res==null || res.length()<1){
                break;
            }
        }
        return res;
    }
    public String inLongestCommonPrefix(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int l = 0;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        StringBuilder stb = new StringBuilder();
        while(l<len1 && l<len2){
            if(cs1[l]==cs2[l]){
                stb.append(cs1[l]);
                l++;
            } else{
                break;
            }
        }
        return stb.toString();
    }
}
