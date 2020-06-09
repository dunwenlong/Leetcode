import java.util.HashMap;

public class LongthOfLongestNoRepeatedSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<1){
            return 0;
        }
        int lenS = s.length();
        HashMap<Character, Integer> record = new HashMap<Character, Integer>();
        int[] dp = new int[lenS];
        int i = -1;
        char[] charArr = s.toCharArray();
        record.put(charArr[0],0);
        dp[0] = 1;
        int maxLen = dp[0];
        for(int j=1; j<lenS; j++){
            if(record.getOrDefault(charArr[j], -2)<i){
                dp[j] = dp[j-1]+1;
            } else{
                i = record.get(charArr[j]);
                dp[j] = j-i;
            }
            maxLen = Math.max(maxLen, dp[j]);
            record.put(charArr[j],j);
        }
        return maxLen;
    }
    public static void main(String[] args){
        System.out.println(LongthOfLongestNoRepeatedSubstring.lengthOfLongestSubstring("abcabcbbbbbb"));
    }
}
