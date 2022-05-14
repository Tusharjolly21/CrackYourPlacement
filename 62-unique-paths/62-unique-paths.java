class Solution {
    public int uniquePaths(int m, int n) {
        return dpMemoize(m,n, new int[m+1][n+1]);
        
    }
    private int dpMemoize(int m,int n,int[][] dp){
        if(m==1 || n==1) return 1;
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        int down = dpMemoize(m-1,n,dp);
        int right = dpMemoize(m,n-1,dp);
        int ans = down+right;
        dp[m][n] = ans;
        return ans;
    }
}