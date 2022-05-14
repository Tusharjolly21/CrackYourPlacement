class Solution {
    public int uniquePaths(int m, int n) {
        // return dpMemoize(m,n, new int[m+1][n+1]);
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                if(i==1 || j==1) dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
        
    }
    // private int dpMemoize(int m,int n,int[][] dp){
    //     if(m==1 || n==1) return 1;
    //     if(dp[m][n]!=0){
    //         return dp[m][n];
    //     }
    //     int down = dpMemoize(m-1,n,dp);
    //     int right = dpMemoize(m,n-1,dp);
    //     int ans = down+right;
    //     dp[m][n] = ans;
    //     return ans;
    // }
}