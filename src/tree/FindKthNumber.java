package tree;

/**
 * @author Dun Wenlong
 * @time 2020/6/25 13:59
 * 找到1~n的字典序第k小的数
 */
public class FindKthNumber {
    public static int findKthNumber(int n, int k){
        int cur = 1;
//        k = k-1;
        while(k>1){
            int num = getNode(n, cur, cur+1);
            if(num<=k){
                cur = cur+1;
                k = k-num;
            } else{
                cur = cur*10;
                k = k-1;
            }
        }
        return cur;
    }

    /**返回前缀下节点的数目*/
    private static int getNode(int n, int first, int last) {
        int num = 0;
        while(first<=n){
            num += Math.min(last, n+1)-first;
            first *= 10;
            last *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(FindKthNumber.findKthNumber(10,1));
        System.out.println("end");
    }
}
