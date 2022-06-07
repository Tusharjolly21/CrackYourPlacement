class Solution {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans);
        return ans;
        
    }

    private void solve(int cols, char[][] board, List<List<String>> ans) {
        if (cols == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int rows = 0; rows < board.length; rows++) {
            if (isSafe(board, rows, cols)) {
                board[rows][cols] = 'Q';
                solve(cols + 1, board, ans);
                board[rows][cols] = '.';
                /*There will be some moment when we do not find the answer therefore while going back whenever we do not find the answer just remove the queen where it was placed when you do not fnd the answer just backtrack from there*/
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }

    private boolean isSafe(char[][] board, int rows, int cols) {
        /*upper diagonal*/
        int dupRow = rows;
        int dupCol = cols;
        while (rows >= 0 && cols >= 0) {
            if (board[rows][cols] == 'Q') return false;
            rows--;
            cols--;
        }
        rows = dupRow; 
        cols = dupCol;
        /*column check to Q of left*/
        while (cols >= 0) {
            if (board[rows][cols] == 'Q') return false;
            cols--;
        }
        rows = dupRow; 
        cols = dupCol; 
        /*lower left diagonal check to left of Q*/
        while (rows < board.length && cols >= 0) {
            if (board[rows][cols] == 'Q') return false;
            cols--;
            rows++;
        }
        return true;
    }
}
