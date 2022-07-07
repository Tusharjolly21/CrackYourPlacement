class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return numDis(s,t,n-1,m-1,dp);
    }
    private int numDis(String s,String t,int n,int m,int[][] dp){
        if(m<0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n][m]!=-1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            int leaveOne = numDis(s,t,n-1,m-1,dp);
            int stay = numDis(s,t,n-1,m,dp);
            dp[n][m] =  (leaveOne+stay);
        }else{
            dp[n][m] =  numDis(s,t,n-1,m,dp);
            
        }
        return dp[n][m];
            
    }
    
}