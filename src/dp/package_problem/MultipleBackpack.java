package dp.package_problem;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/7/21 18:39
 * 有 N 种物品和一个容量是 V 的背包。
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 * 输出格式
 * 输出一个整数，表示最大价值。
 */
public class MultipleBackpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int v = scanner.nextInt();
            int[] vi = new int[n];
            int[] wi = new int[n];
            int[] si = new int[n];
            for (int i = 0; i < n; i++) {
                vi[i] = scanner.nextInt();
                wi[i] = scanner.nextInt();
                si[i] = scanner.nextInt();
            }
            System.out.println(getMaxValue(v, vi, wi, si));
        }
    }
    /* 空间优化 */
    private static int getMaxValue(int v, int[] vi, int[] wi, int[] si) {
        int n = vi.length;
        /* dp[j] 表示前i件物品恰放入容量为j的背包的最大价值 */
        int[] dp = new int[v + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = v; j >=0; j--) {
                for(int k = 0; k<=si[i]; k++){
                    if (j >= vi[i - 1]) {
                        dp[j] = Math.max(dp[j], dp[j - k*vi[i - 1]] + k*wi[i - 1]);
                    } else{
                        break;
                    }
                }
            }
        }
        return dp[v];
    }
}
