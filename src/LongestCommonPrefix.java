/**
 * @author Dun Wenlong
 * @date 2020/6/15
 * 最长公共前缀
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int lenStr = strs.length;
        if(strs.length<1){
            return "";
        }
        int i=0;
        int lenS = strs[0].length();
        boolean isBreak = false;
        while(i<lenS){
            char c = strs[0].charAt(i);
            for(int j=1; j<lenStr; j++){
                if( strs[j].length()<=i ||
                        strs[j].charAt(i)!=c){
                    isBreak = true;
                    break;
                }
            }
            if(isBreak){
                break;
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}
