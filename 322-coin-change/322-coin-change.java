class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int nonPick = 0 + dp[i - 1][j];
                int pick = (int) Math.pow(10, 9);
                if (coins[i-1] <= j) {
                    pick = 1 + dp[i][j - coins[i-1]];
                }
                dp[i][j] = Math.min(pick, nonPick);
            }
        }
         if(dp[n][amount]>=(int)Math.pow(10,9)) return -1;
        else return dp[n][amount];
    }
}
