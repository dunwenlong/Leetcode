public class MaxPricesGift {
    public static int maxGift(int[][] prices){
        int rows = prices.length;
        if(rows<1){
            return 0;
        }
        int columns = prices[0].length;
        int [][] dp = new int[rows][columns];
        int temp = 0;
        for(int i=0; i<rows; i++){
            temp += prices[i][0];
            dp[i][0] = temp;
        }
        temp = 0;
        temp = prices[0][0];
        for(int i=1; i<columns; i++){
            temp += prices[0][i];
            dp[0][i] = temp;
        }
        for(int i= 1; i<rows; i++){
            for(int j= 1; j<columns; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+prices[i][j];
            }
        }
        return dp[rows-1][columns-1];
    }
    public static void main(String[] args){
        int[][] testData = {{1,2,5},{3,2,1}};
        System.out.println(MaxPricesGift.maxGift(testData));
    }
}
