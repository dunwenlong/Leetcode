import java.util.Arrays;

/**
 * @author Dun Wenlong
 * @date 2020/6/14
 * 转变数组后最接近目标值的数组和
 */
public class FindBestValue {
    public int findBestValue(int[] arr, int target) {
        if(arr.length<1){
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length;
        int tempSum = 0;
        for(int i=0; i<len; i++){
            int x = (target-tempSum)/(len-i);
            if(x<arr[i]){
                double t = 1.0*(target-tempSum)/(len-i);
                if(t-x>0.5){
                    return x+1;
                } else{
                    return x;
                }
            }
            tempSum += arr[i];
        }
        return arr[len-1];
    }
}
