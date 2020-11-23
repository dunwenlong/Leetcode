package everyday;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Dun Wenlong
 * @time 2020/11/14 16:30
 * * 面试题 17.05.  字母与数字
 * * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 * *
 * * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 * *
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/find-longest-subarray-lcci
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLongestSubarray1114 {
    public String[] findLongestSubarray(String[] array) {
        int nArray = array.length;
        int[] nums = new int[nArray];
        for (int i = 0; i < nArray; i++) {
            if (isNumber(array[i])) {
                nums[i] = -1;
            } else {
                nums[i] = 1;
            }
        }
        HashMap<Integer, Integer> preMap = new HashMap<>();
        int[] preSum = new int[nArray + 1];
        for (int i = 1; i <= nArray; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            preMap.put(preSum[i], i);
        }
        int[] res = new int[2];
        int maxLen = 0;
        for (int i = 0; i <= nArray; i++) {
            if (preSum[i] == 0) {
                if (i > maxLen) {
                    res[0] = 0;
                    res[1] = i - 1;
                    maxLen = i;
                }
            }
            if (preMap.containsKey(preSum[i])) {
                int j = preMap.get(preSum[i]);
                if (j - i > maxLen) {
                    res[0] = i;
                    res[1] = j - 1;
                    maxLen = j - i;
                }
            } else {
                continue;
            }
        }
        if(maxLen == 0){
            return new String[]{};
        }
        return Arrays.copyOfRange(array, res[0], res[1] + 1);
    }

    public boolean isNumber(String str) {
        return Character.isDigit(str.toCharArray()[0]);
    }

    public boolean isChar(String str) {
        return Character.isLetter(str.toCharArray()[0]);
    }

    public static void main(String[] args) {
        String[] array = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        System.out.println(Arrays.toString(new FindLongestSubarray1114().findLongestSubarray(array)));
    }
}
