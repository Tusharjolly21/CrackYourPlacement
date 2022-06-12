class Solution {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(char i[] : board)
        Arrays.fill(i, '.');
        return solve(0, board);
    }
     private int solve(int cols, char[][] board) {
        if (cols == board.length) {
            return 1;
        }
        int count = 0;
        for (int rows = 0; rows < board.length; rows++) {
            if (isSafe(board, rows, cols)) {
                board[rows][cols] = 'Q';
                count+=solve(cols + 1, board);
                board[rows][cols] = '.';
                /*There will be some moment when we do not find the answer therefore while going back whenever we do not find the answer just remove the queen where it was placed when you do not fnd the answer just backtrack from there*/
            }
            
        }
         return count;
    }
    private boolean isSafe(char board[][], int row, int col){
        int dupRow = row;
        int dupCol = col;
        
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}