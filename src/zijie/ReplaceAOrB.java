package zijie;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/14 15:19
 */
public class ReplaceAOrB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String input = sc.next();
            char[] cs = input.toCharArray();
            int countA = 0;
            int countB = 0;
            int ans = 0;
            int l = 0;
            int r = 0;
            while(r<n){
                if(cs[r] == 'a'){
                    ++countA;
                } else{
                    ++countB;
                }
                if(countA<= m || countB<= m){
                    ans = Math.max(ans, r-l+1);
                } else{
                    while(countA>m && countB>m){
                        if(cs[l] =='a'){
                            --l;
                            --countA;
                        } else{
                            --l;
                            --countB;
                        }
                    }
                }
                r++;
            }
            System.out.println(ans);
        }
    }
}