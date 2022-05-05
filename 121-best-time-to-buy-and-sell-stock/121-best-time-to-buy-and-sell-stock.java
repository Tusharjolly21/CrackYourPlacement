class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = Integer.MIN_VALUE;
        int minNum = prices[0];
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<minNum) minNum = prices[i];
            maxDiff = Math.max(maxDiff,prices[i]-minNum);
        }
        return maxDiff;
    }
}