class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // return recursive(text1,text2,m,n);
        // return dpMemoize(text1,text2,m,n,new int[m+1][n+1]);
        int[][] dp = new int[m+1][n+1];
    for(int i = 1;i<m+1;i++){
        for(int j = 1;j<n+1;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
    return dp[m][n];
}
//     private int recursive(String s, String t, int m, int n) {
        
//         if (s.charAt(m - 1) == t.charAt(n - 1)) {
//             return 1 + recursive(s, t, m - 1, n - 1);
//         } else{
//             return Math.max(recursive(s,t,m-1,n),recursive(s,t,m,n-1));
//         }
//     }
    // private int dpMemoize(String s,String t,int m,int n, int[][] dp){
    //     if (m == 0 || n == 0) return 0;
    //     if(dp[m][n]!=0){
    //         return dp[m][n];
    //     }
    //     if (s.charAt(m - 1) == t.charAt(n - 1)) {
    //         dp[m][n] =  1 + dpMemoize(s, t, m - 1, n - 1,dp);
    //     } else{
    //         dp[m][n] =  Math.max(dpMemoize(s,t,m-1,n,dp),dpMemoize(s,t,m,n-1,dp));
    //     }
    //     return dp[m][n];
    // }
    
}