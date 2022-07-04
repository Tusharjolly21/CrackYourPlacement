class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return tabulation(nums,dp,n-1);
    }
    private int tabulation(int[] arr,int[] dp,int n){
        dp[0] = arr[0];
        int neg = 0;
        for(int i = 1;i<arr.length;i++){
            int pick = arr[i];
            if(i>1) pick+=dp[i-2];
            int nonPick = 0+dp[i-1];
            dp[i] = Math.max(pick,nonPick);
        }
        return dp[n];
    }
}