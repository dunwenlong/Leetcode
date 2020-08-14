package zijie;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/14 10:27
 * 题目：存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),
 * 现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 *     A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 *     B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 * 思路：因为i所能够传送的房间pi<=i，因此要想传送到n+1房间，前n个房间的访问次数必定为偶数，因此使用dp[i]表示第一次访问房间i所需要的移动的次数，
 * 只能通过房间i-1到达房间i,因此房间i-1访问偶数次，则dp[i] = dp[i-1]+(第一次访问i-1之后，下一步会传送到pi,从pi到i-1的步数)+1；
 * 所以dp[i] = dp[i-1] + (1 + dp[i-1] - dp[p[i-1]]) +1;
 */
public class MoveRoom {
    public static final int CONST_NUM = 1000000007;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] p = new int[n+1];
            for(int i=1; i<=n; i++){
                p[i]  = scanner.nextInt();
            }
            int[] dp = new int[n+2];
            dp[1] = 0;
            for(int i=2; i<=n+1; i++){
                dp[i] = (2*dp[i-1]+2-dp[p[i-1]])%CONST_NUM;
            }
            System.out.println(dp[n+1]);
        }
    }
}
