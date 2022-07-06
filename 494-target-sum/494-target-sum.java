class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        /*Invalid sum*/
        if(sum < Math.abs(target) || (target+sum) %2 != 0) return 0;
        int ans = (target+sum)/2;
        int[][] dp = new int[n+1][ans+1];
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<ans+1;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else if(i==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 0;j<ans+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][ans];
    }
}
/*
This problem is equal to "find all ways to partition the array into two groups so that the difference of the sum of the two groups is Math.abs(S)". Assume the sum of the two subsets is s1 and s2 (s1 >= s2), the sum of the array is sum:

s1 + s2 = sum;
s1 - s2 = Math.abs(S)
So, s1 = (sum + Math.abs(S)) / 2. Now what we need to do is finding all subsets whose sum is s1, which is a typical 0-1 knapsack problem.
We use dp[i][j] to denote the number of subsets whose sum is i for the first j elements in the array.
Note that there could be zero in the array, dp[0][i] is no longer 0 as the normal knapsack problem, which means we need to process empty knapsack specially.
*/