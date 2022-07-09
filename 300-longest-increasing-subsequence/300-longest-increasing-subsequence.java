class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1; i>= 0; i--){
            for(int prev=i-1; prev >= -1; prev--){
                int notPick = dp[i+1][prev+1];
                int pick = -1;
                if(prev == -1 || nums[i]>nums[prev])
                    pick = 1 + dp[i+1][i+1];
                dp[i][prev+1] = Math.max(pick,notPick);
            }
        }
        return dp[0][0];
    } 
}