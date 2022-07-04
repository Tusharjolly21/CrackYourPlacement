class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }
    private int solve(int index,int[] arr,int[] dp){
        if(index<0) return 0;
        if(index==0) return arr[0];
        if(index == 1) return Integer.max(arr[1], arr[0]);
        if(dp[index]!=-1) return dp[index];
        int pick = arr[index]+solve(index-2,arr,dp);
        int nonPick = 0+solve(index-1,arr,dp);
        dp[index] = Integer.max(pick,nonPick);
        return dp[index];
    }
}