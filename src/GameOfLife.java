public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] tempBoard = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                tempBoard[i][j] = board[i][j];
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(getIsLive(tempBoard, i, j)){
                    board[i][j] = 1;
                } else{
                    board[i][j] = 0;
                }
            }
        }
    }

    private boolean getIsLive(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        int numLive = 0;
        int numNoLive = 0;
        //下
        if(i+1<rows && board[i+1][j]==1){
            numLive++;
        }
        if(i+1<rows && board[i+1][j]==0){
            numNoLive++;
        }
        //右
        if(j+1<cols && board[i][j+1]==1){
            numLive++;
        }
        if(j+1<cols && board[i][j+1]==0){
            numNoLive++;
        }
        //上
        if(i-1>=0 && board[i-1][j]==1){
            numLive++;
        }
        if(i-1>=0 && board[i-1][j]==0){
            numNoLive++;
        }
        //左
        if(j-1>=0 && board[i][j-1]==1){
            numLive++;
        }
        if(j-1>= 0 && board[i][j-1]==0){
            numNoLive++;
        }
        //对角
        //右下
        if(i+1<rows && j+1<cols && board[i+1][j+1]==1){
            numLive++;
        }
        if(i+1<rows && j+1<cols && board[i+1][j+1]==0){
            numNoLive++;
        }
        //左下
        if(i+1 <rows && j-1>=0 && board[i+1][j-1]==1){
            numLive++;
        }
        if(i+1 <rows && j-1>=0 && board[i+1][j-1]==0){
            numNoLive++;
        }
        //左上
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1){
            numLive++;
        }
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==0){
            numNoLive++;
        }
        //右上
        if(i-1>=0 && j+1<cols && board[i-1][j+1]==1){
            numLive++;
        }
        if(i-1>=0 && j+1<cols && board[i-1][j+1]==0){
            numNoLive++;
        }
        if(board[i][j] == 1 && numLive<2){
            return false;
        }
        if(board[i][j] == 1 &&(numLive == 2 || numLive == 3)){
            return true;
        }
        if(board[i][j] == 1 && numLive>3){
            return false;
        }
        if(board[i][j] == 0 && numLive==3){
            return true;
        }
        return board[i][j]==1;
    }
}
