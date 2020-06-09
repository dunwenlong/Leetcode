/**
 * @author Admin
 */
public class TranslateNum {
    public int translateNum(int num) {
        String strNum = String.valueOf(num);
        int len = strNum.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0] = 1;
                continue;
            }
            if (i == 1) {
                int temp = Integer.valueOf(strNum.substring(0, 2));
                if (temp >= 10 && temp <= 25) {
                    dp[i] = 2;
                } else {
                    dp[i] = 1;
                }
                continue;
            }
            int temp = Integer.valueOf(strNum.substring(i - 1, i + 1));
            if (temp >= 10 && temp <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len - 1];
    }
}

