// 0-1背包问题
public class ZeroOnePack {
    // values中是若干物品的价值， weights中为对应得重量，totalWeight为背包的总重量
    public int getZeroOnePack(int[] values, int[] weights, int totalWeight){
        int nV = values.length;
        int[][] dp = new int[nV+1][totalWeight+1];
        for(int i=0; i<totalWeight+1; i++){
            dp[0][i] = 0;
        }
        for(int j=0; j<nV+1; j++){
            dp[j][0] = 0;
        }
        for(int i=1; i<nV+1; i++){
            for(int j=0; j<totalWeight+1; j++){
                if(j<weights[i]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        return dp[nV][totalWeight];
    }
    //空间优化
    public int getZeroOnePack2(int[] values, int[] weights, int totalWeight){
        int nV = values.length;
        int[] dp = new int[totalWeight+1];
        for(int i=1; i<nV+1; i++){
            for(int j=totalWeight; j>=weights[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-weights[i]]+values[i]);
            }
        }
        return dp[totalWeight];
    }
//    面试题 08.11. 硬币
    public static int CompletePack(int n){
        int[] weights = {25, 10, 5, 1};
        int[][] dp = new int[weights.length+1][n+1];
        dp[0][0] = 1;
        for(int i=1; i<n+1; i++){
            dp[0][i] = 1;
        }
        for(int j=1; j<weights.length+1; j++){
            dp[j][0] = 1;
        }
        for(int j=1; j<weights.length+1; j++){
            for(int i=weights[j-1]; i<n+1; i++){
                dp[j][i] = dp[j-1][i] + dp[j][i-weights[j-1]];
            }
        }
        return dp[4][n];
    }
    public static void main(String[] args){
        System.out.println(ZeroOnePack.CompletePack(10));
    }
}
