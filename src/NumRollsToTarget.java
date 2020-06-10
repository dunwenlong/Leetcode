import java.util.LinkedList;

/**
 * @author dunwenlong
 */
public class NumRollsToTarget {
    private static int count = 0;
//  回溯法
//    public static int numRollsToTarget(int d, int f, int target) {
//        LinkedList<Integer> path = new LinkedList<>();
//        dfs(d, f, 0, target, path);
//        return count;
//    }
//
//    private static void dfs(int d, int f, int sum, int target, LinkedList<Integer> path) {
//        if (target == sum) {
//            count++;
//            return;
//        }
//        if (target < sum) {
//            return;
//        }
//        if (d == 0) {
//            return;
//        }
//        for (int i = 1; i <= f; i++) {
//            path.addLast(i);
//            sum = sum+i;
//            dfs(d - 1, f, sum, target, path);
//            path.removeLast();
//            sum = sum -i;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(NumRollsToTarget.numRollsToTarget(10, 5, 180));
    }

    private static int numRollsToTarget(int d, int f, int target) {
        //dp[d][target] 表示d个色子，和为目标值时的总数目
        int modNum = 1000000007;
        int[][] dp = new int[d + 1][d * f + 1];
        if (d == 1 && f < target) {
            return 0;
        }
        if(d*f<target){
            return 0;
        }
        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }
        for (int j = 2; j <= d; j++) {
            for (int t = j; t <= target; t++) {
                int temp = 0;
                for (int i = 1; i <= f; i++) {
                    if (t - i >= 0) {
                        temp = (temp + dp[j - 1][t - i])%modNum;
                    }
                }
                dp[j][t] = temp;
            }
        }
        return dp[d][target];
    }
}
