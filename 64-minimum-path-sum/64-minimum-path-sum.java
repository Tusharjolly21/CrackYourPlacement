class Solution {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return dpMemoize(rows-1,cols-1,grid,new int[rows+1][cols+1]);
    }

    private int dpMemoize(int rows, int cols, int[][] grid,int[][] dp) {
        if (rows == 0 && cols == 0) return grid[rows][cols];
        if(dp[rows][cols]!=0){
            return dp[rows][cols];
        }
        if (rows == 0) return grid[rows][cols] + dpMemoize(rows, cols - 1, grid,dp);
        if (cols == 0) return grid[rows][cols] + dpMemoize(rows - 1, cols, grid,dp);
        int down = grid[rows][cols] + dpMemoize(rows - 1, cols, grid,dp);
        int right = grid[rows][cols] + dpMemoize(rows, cols - 1, grid,dp);
        int ans = Math.min(down,right);
        dp[rows][cols] = ans;
        return ans;
    }
}
