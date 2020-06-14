import java.util.LinkedList;
import java.util.List;

/**
 * @author Admin
 */
public class TestJava {
    public static void main(String[] args) {
        System.out.println("good");
    }

    LinkedList<int[]> res = new LinkedList<>();

    public List<int[]> pathWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (rows < 1) {
            return res;
        }
        if (obstacleGrid[0][0] == 1) {
            return res;
        }
        //-1表示不可达，0表示从左面，1表示从上面
        int[][] dp = new int[rows][cols];
        for (int i = 1; i < rows; i++) {
            if (dp[i - 1][0] != -1 && obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = -1;
            }
        }
        for (int j = 1; j < cols; j++) {
            if (dp[0][j - 1] == -1 || obstacleGrid[0][j] == 1) {
                dp[0][j] = -1;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] != 1) {
//                    if (obstacleGrid[i][j - 1] != -1) {
//                        dp[i][j] = 0;
//                    }
//                    if (obstacleGrid[i - 1][j] != -1) {
//                        dp[i][j] = 1;
//                    }
                    if(obstacleGrid[i-1][j]!=-1){
                        dp[i][j] = 1;
                    } else if(obstacleGrid[i][j-1]!=-1){
                        dp[i][j] = 0;
                    } else{
                        dp[i][j] = -1;
                    }
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        if (dp[rows - 1][cols - 1] == -1) {
            return res;
        }
        getPath(rows - 1, cols - 1, dp);
        return res;
    }

    private void getPath(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            res.add(new int[]{0, 0});
        }
        if (dp[i][j] == 0) {
            getPath(i, j - 1, dp);
        }
        if (dp[i][j] == 1) {
            getPath(i - 1, j, dp);
        }
        res.add(new int[]{i, j});
    }
}
