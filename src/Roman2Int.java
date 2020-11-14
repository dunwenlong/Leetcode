/**
 * @author Dun Wenlong
 * @time 2020/9/3 11:00
 */
public class Roman2Int {
    public int romanToInt(String s) {
        if(s == null || s.length()<1){
            return 0;
        }
        int sum = 0;
        char[] cs = s.toCharArray();
        int preNum = getValue(cs[0]);
        int lenS = cs.length;
        for(int i=1; i<lenS; i++){
            int num = getValue(cs[i]);
            if(num>preNum){
                sum += (-preNum);
            } else{
                sum += (+preNum);
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
