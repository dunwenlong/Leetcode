package zijie;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/14 14:06
 * 有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，
 * 每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分
 * 相差d2分，每场比赛可以任意选择两只队伍进行。求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。
 * 思路：
 * 首先考虑试题，失败不扣分，没有平局，赢了加1分，则总分就是N，如果N不能被3整除，则不能平局
 * 然后考虑分差，如果剩余比赛（N-K）不足以弥补分差（d1+d2）那就肯定不能平局。
 * 在考虑剩下的情况，如果是平局则每个球队得分应该都是N/3,如果其中一个球队得分大于N/3，则不能平局。
 * 试题转换为判断当前比赛有没有球队得分超过N/3；
 * 设最少得分的球队为M，
 * 则三队得分有4种可能：
 * M，M+d1，M+d2+d1；
 * M，M+d2，M+d2+d1；
 * M，M+d1，M+d2；
 * M，M+d1，M+d1-d2；（假设d1大于d2）
 * 求出M的值（M需要满足大于等于0，能被三整除），然后就可以计算出得分最高的球队，如果最高得分不高于N/3，则就算成功
 * （如果多个情况都满足条件，则其中有一个可以满足就行）
 */
public class PlayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                if (judge(scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong())) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }

    private static boolean judge(long n, long k, long d1, long d2) {
        if (n % 3 != 0 || n - k < d1 + d2) {
            return false;
        }
        Long maxd = d1 > d2 ? d1 : d2;
        Long mind = d1 < d2 ? d1 : d2;
        Long m1 = k - 2 * d1 - d2;
        Long m2 = k - 2 * d2 - d1;
        Long m3 = k - d1 - d2;
        Long m4 = k - 2 * maxd + mind;
        if ((m1 >= 0 && m1 % 3 == 0 && m1 / 3 + d1 + d2 <= n / 3)
                || (m2 >= 0 && m2 % 3 == 0 && m2 / 3 + d1 + d2 <= n / 3)
                || (m3 >= 0 && m3 % 3 == 0 && m3 / 3 + maxd <= n / 3)
                || (m4 >= 0 && m4 % 3 == 0 && m4 / 3 + maxd > 0)) {
            return true;
        }
        return false;


    }
}
