class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[rows][cols];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i = 0;i<cols;i++){
            min = Math.min(min,minPath(rows-1,i,matrix,dp));
        }
        return min;
        
    }
    private int minPath(int i,int j, int[][] matrix,int[][] dp){
        if(j<0 || j>=matrix[0].length) return (int)Math.pow(10,9);
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        
        int leftDiagonal = matrix[i][j]+minPath(i - 1, j - 1,matrix,dp);
        int down = matrix[i][j]+minPath(i - 1, j,matrix,dp);
        int right = matrix[i][j]+minPath(i - 1, j + 1,matrix,dp);
        dp[i][j] =  Math.min(Math.min(down,right),leftDiagonal);
        return dp[i][j];
    }
}