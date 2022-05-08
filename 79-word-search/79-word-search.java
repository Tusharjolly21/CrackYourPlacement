class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(board[i][j]==word.charAt(0) && searchWord(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean searchWord(int i,int j,int stringIndex,char[][] board,String word){
        if(stringIndex==word.length()) return true;
        /*if string index is equal to string length means we found the word*/
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(stringIndex)!=board[i][j] || visited[i][j]){
            return false;
        }
        
        
        visited[i][j] = true;
        if(searchWord(i-1,j,stringIndex+1,board,word)||
            searchWord(i+1,j,stringIndex+1,board,word)||
            searchWord(i,j-1,stringIndex+1,board,word)||
            searchWord(i,j+1,stringIndex+1,board,word)){
            return true;
        }
        visited[i][j] = false; /*With the help of visited array we are backtracking, we assigned it false because if none of the paths worked out we need to re-search the grid starting from afresh.*/
        return false;
    }
}