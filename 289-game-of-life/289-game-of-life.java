class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[] dx = {0,0,1,-1,1,-1,-1,1};
        int[] dy = {1,-1,0,0,-1,1,-1,1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            int liveCounts = 0;
        for (int k = 0; k < 8; k++) {
    if (isSafe(i + dx[k], j + dy[k], rows, cols) && Math.abs(board[i + dx[k]][j + dy[k]]) == 1) {
                            liveCounts++;
                        }
                    }
                    if (board[i][j] == 0 && liveCounts == 3)
                        board[i][j] = 2;
                    if (board[i][j] == 1 && (liveCounts < 2 || liveCounts > 3))
                        board[i][j] = -1;
                }
            }
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                board[i][j] = board[i][j]>0?1:0;
            }
        }
        }
    private boolean isSafe(int x,int y,int rows,int cols){
        return (x>=0 && x<rows && y>=0 && y<cols);
    }
}