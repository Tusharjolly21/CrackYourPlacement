class Solution {
    public int climbStairs(int n) {
        return climbStairs(n,new int[n+1]);
        
    }
    private int climbStairs(int n,int[] dp){
        if(n==1 || n==2) return n;
        if(dp[n]!=0){
            return dp[n];
        }
        int climb1 = climbStairs(n-1,dp);
        int climb2 = climbStairs(n-2,dp);
        int ans = climb1+climb2;
        dp[n] = ans;
        return ans;
    }
}