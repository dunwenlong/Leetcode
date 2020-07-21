package dp.package_problem;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/7/21 16:36
 * 有  N  种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 * 第 i 种物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
 * 输出格式
 * 输出一个整数，表示最大价值。
 */
public class CompleteBackpack {
    /* 空间优化 */
    private static int getMaxValue(int v, int[] vi, int[] wi) {
        int n = vi.length;
        /* dp[j] 表示前i件物品恰放入容量为j的背包的最大价值 */
        int[] dp = new int[v + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = vi[i - 1]; j < v + 1; j++) {
                if (j >= vi[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - vi[i - 1]] + wi[i - 1]);
                } else {
                    break;
                }
            }
        }
        return dp[v];
    }

    /**
     * 首先想想为什么 01 背包中要按照 v 递减的次序来循环。让 v 递减是为了保证第 i 次循环中的状态 F[i; v]
     * 是由状态 F[i − 1; v − Ci] 递推而来。
     * 换句话说，这正是为了保证每件物品只选一次，保证在考虑“选入第 i 件物品”这件策
     * 略时，依据的是一个绝无已经选入第 i 件物品的子结果 F[i − 1; v − Ci]。而现在完全背
     * 包的特点恰是每种物品可选无限件，所以在考虑“加选一件第 i 种物品”这种策略时，
     * 却正需要一个可能已选入第 i 种物品的子结果 F[i; v − Ci]，
     */
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
}
