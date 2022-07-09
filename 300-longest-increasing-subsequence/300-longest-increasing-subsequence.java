class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        return maxLen(0,-1,nums,dp);
        
    }
    private int maxLen(int index,int prev_ele,int[] nums,int[][] dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev_ele+1]!=0) return dp[index][prev_ele+1];
        int nonPick = 0+maxLen(index+1,prev_ele,nums,dp);
        int pick = 0;
        if(prev_ele==-1 || nums[index]>nums[prev_ele]){
            pick = 1+maxLen(index+1,index,nums,dp);
        }
        dp[index][prev_ele+1] =  Math.max(nonPick,pick);
        return dp[index][prev_ele+1];
    }
}