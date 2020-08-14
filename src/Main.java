import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/13 21:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            double[] nums = new double[m];
            for (int i = 0; i < m; i++) {
                nums[i] = sc.nextDouble();
            }
            int n = sc.nextInt();
            if (n > m) {
                System.out.println("Error");
            }
//            quickSort(m, nums, 0, m - 1);
            getKthNum(m, nums, 0, m-1, n );
            System.out.println(nums[n - 1]);
        }
    }

    private static void getKthNum(int m, double[] nums, int l, int r, int n) {
        int mid = inGetKthNum(m, nums, l, r);
        if (mid == n - 1) {
            return;
        } else if (mid < n - 1) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }

    private static int inGetKthNum(int m, double[] nums, int l, int r) {
        double q = nums[r];
        int i = l;
        int j = l;
        while (j <= r) {
            if (i == j) {
                if (nums[j] <= q) {
                    i++;
                }
            } else {
                if (nums[j] <= q) {
                    double temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            }
            j++;
        }
        return i - 1;
    }

    private static void quickSort(int m, double[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = inGetKthNum(m, nums, l, r);
        quickSort(m, nums, l, mid - 1);
        quickSort(m, nums, mid + 1, r);
    }
}
