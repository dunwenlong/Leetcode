package dp.package_problem;

/**
 * @author Dun Wenlong
 * @time 2020/7/21 19:53
 * 题目：
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 */
public class WaysToChange {
    public int waysToChangeOld(int n){
        int[] weights = {25, 10, 5, 1};
        int nW = weights.length;
        int[][] dp = new int[nW+1][n+1];
        /*使用dp[i][j]表示使用前i种面值的硬币构成面值为v的方案数，i种硬币值为weights[i], 则：
        * dp[i][j] = dp[i-1][j] + dp[i-1][j-weights[i]] + dp[i-1][j-2weights[i]]+...
        * 且 dp[i][j-weights[i]] = dp[i-1][j-weights[i]] + dp[i-1][j-2*weights[i]]+...
        * 所以 dp[i][j] = dp[i-1][j] + dp[i-1][j-weights]*/
        dp[0][0] = 1;
        for(int i = 1; i<nW+1; i++){
            for(int j=weights[i-1]; j<n+1; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-weights[i-1]])%1000000007;
            }
        }
        return dp[nW][n];
    }
    /**
    * 空间优化
    * */
    public int waysToChange(int n) {
        int[] weights = {25, 10, 5, 1};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int j=1; j<weights.length+1; j++){
            for(int i=weights[j-1]; i<n+1; i++){
                dp[i] = (dp[i] + dp[i-weights[j-1]])%1000000007;
            }
        }
        return dp[n];
    }
}
