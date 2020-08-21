package huawei;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/18 21:17
 */
public class FindNumberOfChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] cs = str.toUpperCase().toCharArray();
            char target = sc.next().toUpperCase().charAt(0);
            int count = 0;
            for (char c : cs) {
                if (c == target) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
