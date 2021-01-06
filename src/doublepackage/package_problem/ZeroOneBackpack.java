package dp.package_problem;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/7/21 15:51
 * 题目: 0 1 背包问题
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 * 第 i 件物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 * 输出格式
 * 输出一个整数，表示最大价值。
 */
public class ZeroOneBackpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int v = scanner.nextInt();
            int[] vi = new int[n];
            int[] wi = new int[n];
            for (int i = 0; i < n; i++) {
                vi[i] = scanner.nextInt();
                wi[i] = scanner.nextInt();
            }
            System.out.println(getMaxValue(v, vi, wi));
        }
    }

    private static int getMaxValue(int v, int[] vi, int[] wi) {
        int n = vi.length;
        /* dp[i][j] 表示前i件物品恰放入容量为j的背包的最大价值 */
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < v + 1; j++) {
                if (j >= vi[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vi[i - 1]] + wi[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][v];
    }
    /* 空间优化 */
    private static int getMaxValueBetter(int v, int[] vi, int[] wi) {
        int n = vi.length;
        /* dp[j] 表示前i件物品恰放入容量为j的背包的最大价值 */
        int[] dp = new int[v + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = v; j >=0; j--) {
                if (j >= vi[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - vi[i - 1]] + wi[i - 1]);
                } else{
                    break;
                }
            }
        }
        return dp[v];
    }
}
