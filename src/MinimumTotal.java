import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()<1){
            return 0;
        }
        int rows = triangle.size();
        int[] minMum = new int[1];
        minMum[0] = Integer.MAX_VALUE;
        backs(0, 0, minMum, triangle.get(0).get(0), triangle, rows);
        return minMum[0];
    }
    private void backs(int deepth, int index, int[] minMum, int sum, List<List<Integer>> triangle, int rows){
        if(deepth == rows-1 && minMum[0]>sum){
            minMum[0] = sum;
            return;
        } else if(deepth == rows-1){
            return;
        }
        if(index >= triangle.get(deepth).size()){
            return;
        }
        backs(deepth+1, index, minMum, sum+triangle.get(deepth+1).get(index), triangle, rows);
        if(index+1 >= triangle.get(deepth).size()){
            return;
        }
        backs(deepth+1, index+1, minMum, sum+triangle.get(deepth).get(index+1), triangle, rows);
    }
    public static void main(String[] args){
        List<List<Integer>> testData = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        testData.add(temp);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(4);
        testData.add(temp2);
        System.out.println(new MinimumTotal().minimumTotal(testData));
    }
}
