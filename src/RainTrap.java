import java.util.ArrayList;

/**
 * @author Admin
 * 接雨水
 */
public class RainTrap {
    public static int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int sum = 0;
        int[] leftMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        int[] rightMaxArr = new int[len];
        rightMaxArr[len-1] = height[len-1];
        for(int i=1; i<len; i++){
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], height[i]);
        }
        for(int i=len-2; i>=0; i--){
            rightMaxArr[i] = Math.max(rightMaxArr[i+1], height[i]);
        }
//        for(int num:leftMaxArr){
//            System.out.println(num+" ");
//        }
//        System.out.println();
//        for(int num:rightMaxArr){
//            System.out.println(num+" ");
//        }
        for(int i=1; i<len-1; i++){
            sum += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int[] height ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(RainTrap.trap(height));
    }
}
