package dp;

/**
 * @author Dun Wenlong
 * @time 2020/7/19 13:31
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 思路：动态规划问题，使用dp[i][j]表示字符串s1的长度为i的字串，s2长度为j的字串能够构成长度为i+j的s3的字串，都从首字母开始。
 */
public class ISInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < n1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }
        for (int j = 1; j < n2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1) ? true : false;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ? true : false)
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ? true : false);
            }
        }
        return dp[n1][n2];
    }
}
