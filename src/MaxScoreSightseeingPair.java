/**
 * @author Dun Wenlong
 * @date 2020/6/17
 * 1014.最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分
 */
public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        //找到A[i]+i和A[j]-j的最大值
        if(A.length<1){
            return 0;
        }
        if(A.length==1){
            return A[0];
        }
        int max1 = A[0];
        int max2 = max1;
        for(int j=1; j<A.length; j++){
            max2 = max1+A[j]-j>max2?max1+A[j]:max2;
            max1 = max1>A[j]+j?max1:A[j]+j;
        }
        return max2;
    }
}
