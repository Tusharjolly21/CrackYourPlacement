class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        return allPaths(rows-1,cols-1,grid,dp);
    }
    private int allPaths(int rows,int cols,int[][] grid,int[][] dp){
        if(rows==0 && cols==0) return grid[0][0];
        if(rows<0 || cols<0) return (int)Math.pow(10,9);
        if(dp[rows][cols]!=0) return dp[rows][cols];
        int up = grid[rows][cols]+allPaths(rows-1,cols,grid,dp);
        int left = grid[rows][cols]+allPaths(rows,cols-1,grid,dp);
        dp[rows][cols] =  Math.min(up,left);
        return dp[rows][cols];
    }
}