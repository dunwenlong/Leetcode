package voicenet;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/9/28 19:43
 */
public class MinestNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println(getResult(num));
        }
    }

    private static int getResult(int num) {
        if(num%2==0 || num%5==0){
            return 0;
        }
        StringBuilder stb = new StringBuilder();
        long[] nums = new long[21];
        for(int i = 0; i < 21; i++){
            stb.append('1');
            nums[i] = Long.valueOf(stb.toString());
        }
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(nums[i]%(long)num == 0L){
                res = String.valueOf(nums[i]).length();
                break;
            }
        }
        return res;
    }
}
