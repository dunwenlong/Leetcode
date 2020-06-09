public class Jump {
    public int jump(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int start = 0;
        int end = 1;
        int steps = 0;
        int max = 0;
        while (end<nums.length){
            for(int i= start; i<end; i++){
                max = Math.max(nums[i]+i, max);
            }
            start = end;
            end = max + 1;
            steps ++;
        }
        return steps;
    }
}
