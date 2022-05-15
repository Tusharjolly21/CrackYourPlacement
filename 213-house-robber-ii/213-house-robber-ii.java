class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int dp[][] = new int[nums.length + 1][2];
        int one = HouseRobberOne(nums,1,nums.length-1,dp,0);
        int two = HouseRobberOne(nums,2,nums.length,dp,1);
        return Math.max(one,two);
    }
    
    public int HouseRobberOne(int []nums,int start,int end,int[][] dp,int idx){
        dp[start][idx] = nums[start - 1];
        for(int i = start;i<end;i++){
            dp[i+1][idx] = Math.max(dp[i][idx],dp[i-1][idx] + nums[i]); 
        }
        return dp[end][idx];
    }
}
