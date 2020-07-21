/**
 *  将整数转化为字符串，难点在于空格,几千，几百万，几十亿的时候需要在后面添加空格，而且比如50时，需要判断个位数是不是0，如果是零就不需要添加空格
 * @author Dun Wenlong
 * @date 2020/6/12
 */
public class NumberToWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder res = new StringBuilder();
        int[] factors = {1000000000, 1000000, 1000, 1};
        int tempNum = 0;
        for(int i=0; i<4; i++){
            tempNum = num/factors[0];
            num = num%factors[0];
            res.append(getNumberString(tempNum, i));
        }
        return res.toString();
    }



    private String getNumberString(int tempNum, int i) {
        String[] ths = {"", "Thousand", "Million", "Billion"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String res = "";
        if(tempNum==0){
            return "";
        }
        if(tempNum<20){
            res = ones[tempNum]+ths[3-i];
        }
        if(tempNum>=20 && tempNum<100){
            res = tens[tempNum/10]+ths[3-i];
        }
        if(tempNum>100){
            res = ones[tempNum/100] +"Hundred";
            if(tempNum%100!=0){
                res += getNumberString(tempNum%100, i);
            }
        }
        return res;
    }
}
