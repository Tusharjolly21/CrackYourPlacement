class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<amount+1;j++){
                if(i==0){
                    dp[i][j] = 0;
                }else if(j==0){
                    dp[i][j] = 1;
                }
            }
        }
    for(int i=1; i<n+1;i++){
        for(int j=1;j<amount+1;j++){
            int notTaken = dp[i-1][j];
            
            int taken = 0;
            if(coins[i-1]<=j)
                taken = dp[i][j-coins[i-1]];
                
            dp[i][j] = notTaken + taken;
        }
    }
    
    return dp[n][amount];
}
    }