package operatestring;

import java.util.ArrayList;

/**
 * @author Dun Wenlong
 * @time 2020/8/24 11:16
 */
public class ConvertZString {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] lists = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            lists[i] = new StringBuilder();
        }
        int len = s.length();
        boolean isDown = true;
        int icur = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (isDown) {
                lists[icur].append(cs[i]);
                icur++;
            } else{
                lists[icur].append(cs[i]);
                icur--;
            }
            if (icur == numRows) {
                isDown = !isDown;
                icur-=2;
            }
            if(i!=0 && icur == 0){
                isDown = !isDown;
            }
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            stb.append(lists[i]);
        }
        return stb.toString();
    }
}
