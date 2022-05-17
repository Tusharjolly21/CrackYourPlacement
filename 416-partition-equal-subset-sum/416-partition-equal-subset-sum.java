class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0) return false;
        int secSum = sum/2;
        boolean[][] dp = new boolean[n+1][secSum+1];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<secSum+1;j++){
                if(j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }
            }
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<secSum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][secSum];
    }
}