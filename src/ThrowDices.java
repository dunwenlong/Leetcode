//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
//
//         
//
//        你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//
//         
//
//        示例 1:
//
//        输入: 1
//        输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @author Dun
 */
public class ThrowDices {
//    public static double[] twoSum(int n) {
//        int[][] dp = new int[n+1][6*n+1];
//        int stateNum = 7;
//        for(int i=1; i<n+1; i++){
//            if(i==1){
//                for(int j=1; j<stateNum; j++){
//                    dp[i][j] = 1;
//                }
//                continue;
//            }
//            for(int j=i; j<6*n+1; j++) {
//                for (int k = 1; k < stateNum; k++) {
//                    if (j - k >= 1) {
//                        dp[i][j] += dp[i - 1][j - k];
//                    }
//                }
//            }
//        }
//        double totalStates = Math.pow(6, n);
//        double [] res = new double[5*n+1];
//        for(int i = n; i<6*n+1; i++){
//            res[i-n] = dp[n][i]/totalStates;
//        }
//        return  res;

    public static double[] twoSum(int n) {
        int[] dp = new int[6*n+1];
        int stateNum = 7;
        for(int i=1; i<n+1; i++){
            if(i==1){
                for(int j=1; j<stateNum; j++){
                    dp[j] = 1;
                }
                continue;
            }
            for(int j=6*i; j>=i; j--) {
                dp[j] = 0;
                for (int k = 1; k < stateNum; k++) {
                    if (j - k < i-1) {
                        break;
                    }
                    dp[j] += dp[j-k];
                }
            }
        }
        double totalStates = Math.pow(6, n);
        double [] res = new double[5*n+1];
        for(int i = n; i<6*n+1; i++){
            res[i-n] = dp[i]/totalStates;
        }
        return  res;
    }
    public static void main(String[] args){
        double[] res = twoSum(2);
        for(double val: res){
            System.out.println(val);
        }
    }
}
