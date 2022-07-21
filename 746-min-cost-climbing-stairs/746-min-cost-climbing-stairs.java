class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        return recursion(n,cost,dp);
    }
    private int recursion(int index,int[] cost,int[] dp){
        if(index==0 || index==1) return 0;
        if(dp[index]!=0) return dp[index];
        int f1 = recursion(index-2,cost,dp)+cost[index-2];
        int f2 = recursion(index-1,cost,dp)+cost[index-1];
        dp[index] = Math.min(f1,f2);
        return dp[index];
    }
}