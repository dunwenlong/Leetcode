//面试题67. 把字符串转换成整数
public class Str2Int {
    public static int strToInt(String str) {
        if(str==null||str.length()<1){
            return 0;
        }
        char[] strs = str.trim().toCharArray();
        if(strs.length<1){
            return 0;
        }
        int i = 1;
        int sig = 1;
        long res = 0;
        int bnd = Integer.MAX_VALUE;
        if(strs[0] == '-'){
            sig = -1;
        } else if(strs[0] !='+'){
            i=0;
        }
        for(int j=i; j<strs.length; j++){
            if(strs[j]<'0' || strs[j]>'9'){
                break;
            }
            res = (long) res*10+(strs[j]-'0');
            if(res>(long)Integer.MAX_VALUE && sig == 1){
                res = Integer.MAX_VALUE;
                break;
            }
            if(res >= ((long)Integer.MAX_VALUE+(long) 1) && sig == -1){
                res = Integer.MIN_VALUE;
                sig = 1;
                break;
            }
        }
        return sig*(int) res;
    }
    public static void main(String[] args){
        System.out.println(Str2Int.strToInt("-1111111111111111"));
    }
}
