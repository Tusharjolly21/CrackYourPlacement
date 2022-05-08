class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int left_sum = 0;
        for(int i = 0;i<k;i++)
            left_sum+=cardPoints[i];
        int max = left_sum;
        int right_sum = 0;
        for(int i = 0;i<k;i++){
            left_sum-=cardPoints[k-1-i];
            right_sum+=cardPoints[len-1-i];
            max = Math.max(max,left_sum+right_sum);
        }
        return max;
        
        
        
        
        
        
    }
}