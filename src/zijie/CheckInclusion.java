package zijie;

/**
 * @author Dun Wenlong
 * @time 2020/9/2 10:12
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
        }
        int[] s2map = new int[26];
        int l = 0;
        for (int j = 0; j < s1.length(); j++) {
            s2map[s2.charAt(j) - 'a']++;
        }
        int r = s1.length();
        while(r<s2.length() && !matches(s1map, s2map)){
            s2map[s2.charAt(l)-'a']--;
            s2map[s2.charAt(r)-'a']++;
            l++;
            r++;
        }
        if(matches(s1map, s2map)){
            return true;
        } else{
            return false;
        }
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }
}