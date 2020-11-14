package everyday;

/**
 * @author Dun Wenlong
 * @time 25/10/2020 上午 9:31
 */
public class LongestMountain {
    public int longestMountain(int[] A) {
        int n = A.length;
        int i = 1;
        int res = 1;
        boolean isLeft = false;
        boolean isRight = false;
        while(i<n){
            if(A[i]<=A[i-1]){
                i++;
                continue;
            }
            int temp = 1;
            while(i<n && A[i]>A[i-1]){
                temp++;
                isLeft = true;
                i++;
            }
            while(i<n && A[i]<A[i-1]){
                temp++;
                isRight = true;
                i++;
            }
            if(isLeft && isRight){
                res = Math.max(res, temp);
                continue;
            }
            i++;
            System.out.println(i);
        }
        if(res<3){
            return 0;
        } else{
            return res;
        }
    }
    public static void main(String[] args){
        LongestMountain test = new LongestMountain();
        int[] nums = {875,884,239,731,723,685};
        System.out.println(test.longestMountain(nums));
    }
}
