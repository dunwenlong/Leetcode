public class MyAtoi {
    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.length()<1){
            return 0;
        }
        char[] c = str.toCharArray();
        StringBuilder temp = new StringBuilder();
        int isPositive = 1;
        int i=0;
        long res = 0;
        int bound = Integer.MAX_VALUE;
        if(c[0]=='-'){
            isPositive = -1;
            i++;
        } else if(c[0]=='+'){
            i++;
        }
        while (i<c.length){
            if(c[i]>='0' && c[i]<='9'){
                res +=(long)res*10+c[i]-'0';
            } else{
                break;
            }
            if(res>=bound && isPositive == 1){
                res = Integer.MAX_VALUE;
                break;
            }
            if(res>=(long) bound+1 && isPositive == -1){
                isPositive = 1;
                res = Integer.MIN_VALUE;
                break;
            }
            i++;
        }
        return isPositive*(int)res;
    }
}
