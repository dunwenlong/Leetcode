package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/9/17 16:40
 */
public class AvoidFlooding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rains = new int[n];
        for (int i = 0; i < n; i++) {
            rains[i] = sc.nextInt();
        }
        int[] res = avoidFlood(rains);
    }

    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        /*zeros 存放第几天是晴天*/
        ArrayList<Integer> zeros = new ArrayList<>();
        /*records 中存储的是湖的索引，和下雨的日期*/
        HashMap<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                int temp = rains[i];
                if (records.containsKey(temp)) {
                    /*找到离下雨天最近的晴天*/
                    // System.out.println("temp"+records.get(temp));
                    int binRes = myBinarySearch(zeros, records.get(temp));
                    if (binRes >= 0) {
                        // System.out.println("binRes "+binRes);
                        // System.out.println("zeros "+zeros.get(binRes));
                        res[zeros.get(binRes)] = temp;
                        zeros.remove(binRes);
                        records.put(temp, i);
                    } else {
                        return new int[0];
                    }
                } else {
                    records.put(temp, i);
                }
                res[i] = -1;
            } else {
                zeros.add(i);
            }
        }
        return res;
    }

    public static int myBinarySearch(ArrayList<Integer> zeros, Integer key) {
        int n = zeros.size();
        if (n < 1) {
            return -1;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (zeros.get(mid) > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
