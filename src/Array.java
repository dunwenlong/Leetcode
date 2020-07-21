/**
 * @author Dun Wenlong
 * @time 2020/6/27 20:55
 * 题目：缺失的第一个正数
 * 思路：1、将负数全部变为N+1; 2、遍历所有数，取该数的绝对值，然后将绝对值所对应索引的值取负数，如果已为负数不做处理
 * 3、找出数组中的第一个大于0的值的索引，说明该值对应的数不存在
 */
public class Array {
    public static int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for(int i=0; i<N; i++){
            if(nums[i]<1){
                nums[i] = N+1;
            }
        }
        for(int i=0; i<N; i++){
            int temp = Math.abs(nums[i]);
            if(temp>0&&temp<N+1){
                if(nums[temp-1]<0){
                    continue;
                } else{
                    nums[temp-1] = -nums[temp-1];
                }
            }
        }
        for(int i=0; i<N; i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return N+1;
    }
    public static void main(String[] args){
        System.out.println(Array.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
