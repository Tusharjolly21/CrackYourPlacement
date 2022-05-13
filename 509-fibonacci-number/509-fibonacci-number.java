class Solution {
    public int fib(int n) {
        return dp(n,new int[n+1]);
    }
    private int dp(int n,int[] dp){
        if(n==0 || n==1) return n;
        if(dp[n]!=0) return dp[n];
        int fib1 = dp(n-1,dp);
        int fib2 = dp(n-2,dp);
        int ans = fib1+fib2;
        dp[n] = ans;
        return ans;
    }
}