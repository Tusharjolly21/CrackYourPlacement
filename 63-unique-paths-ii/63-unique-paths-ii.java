class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        return uniquePaths(rows-1,cols-1,obstacleGrid,new int[rows+1][cols+1]);
        
    }
private int uniquePaths(int rows,int cols, int[][] obstacleGrid, int[][] dp ){
        if(rows>=0 && cols>=0 && obstacleGrid[rows][cols]==1) return 0;
        if(rows==0 && cols==0) return 1;
        if(rows<0 || cols<0) return 0;
    if(dp[rows][cols]!=0){
        return dp[rows][cols];
    }
        int down = uniquePaths(rows-1,cols,obstacleGrid,dp);
        int right = uniquePaths(rows,cols-1,obstacleGrid,dp);
        return dp[rows][cols] =  down+right;
}
    
     
}