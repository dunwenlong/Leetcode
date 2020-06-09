//面试题44. 数字序列中某一位的数字
public class FindNthDigit {
    public static int findNthDigit(int n) {
        if(n==0){
            return 0;
        }
        int start = 1;
        long conut = 9;
        int end = 9;
        int digit = 1;
        while(n>conut){
            n = (int) (n-conut);
            start = start*10;
            digit ++;
            conut = (long) digit*start*9;
        }
        int num = start + (n-1)/digit;
        return Integer.toString(num).charAt((n-1)%digit)-'0';
    }
    public static void main(String[] args){
        System.out.println(FindNthDigit.findNthDigit(10000));
    }
}
