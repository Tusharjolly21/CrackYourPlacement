class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans =  totalCoins(coins,n-1,amount,dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        else return ans;
    }
    private int totalCoins(int[] coins,int n,int amount,int[][] dp){
        if(n==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return (int)Math.pow(10,9);
            }
        }
        if(dp[n][amount]!=-1) return dp[n][amount];
        int notTaken = 0 + totalCoins(coins,n-1,amount,dp);
    
    int taken = (int)Math.pow(10,9);
    if(coins[n] <= amount)
        taken = 1 + totalCoins(coins,n,amount-coins[n],dp);
        
    dp[n][amount] =  Math.min(notTaken,taken);
        return dp[n][amount];
    }
}