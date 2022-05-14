class Solution {

    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversedString = sb.reverse().toString();
        int m = s.length();
        int n = s.length();
        return n - lcs(s, reversedString, m,n);
    }

    private int lcs(String s, String t, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            
        }
        return dp[m][n];
    }
}
