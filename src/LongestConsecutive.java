import java.util.HashSet;
import java.util.Set;

/**
 * @author Admin
 * 最长连续序列
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int num: nums){
            numsSet.add(num);
        }
        int longest = 0;
        for(int num: numsSet){
            if(!numsSet.contains(num-1)){
                int curNum = num;
                int curLength = 0;
                while (numsSet.contains(curNum)){
                    curNum += 1;
                    curLength++;
                }
                longest = Math.max(longest, curLength);
            }
        }
        return longest;
    }
}
