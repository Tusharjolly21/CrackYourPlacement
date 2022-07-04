class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        return obstacle(rows-1,cols-1,obstacleGrid,dp);
        
        
    }
    public int obstacle(int m,int n,int[][] obstacleGrid,int[][] dp){
        if(m>=0 && n>=0 && obstacleGrid[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=0) return dp[m][n]; 
        dp[m][n] = obstacle(m-1,n,obstacleGrid,dp)+obstacle(m,n-1,obstacleGrid,dp);
        return dp[m][n];
    }
}