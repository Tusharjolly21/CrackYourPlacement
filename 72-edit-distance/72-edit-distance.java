class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return recursion(word1,word2,n-1,m-1,dp);
    }
    private int recursion(String s,String t,int n,int m,int[][] dp){
        if(n<0){
            return m+1;
        }
        if(m<0){
            return n+1;
        }
        if(dp[n][m]!=-1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            dp[n][m] =  0+recursion(s,t,n-1,m-1,dp);
        }else{
            dp[n][m] =  1+Math.min(recursion(s,t,n-1,m,dp),Math.min(recursion(s,t,n,m-1,dp),recursion(s,t,n-1,m-1,dp)));
        }
        return dp[n][m];
    }
}