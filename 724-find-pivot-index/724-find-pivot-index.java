class Solution {
    public int pivotIndex(int[] nums) {
        int left_sum = 0;
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
            sum+=nums[i];
        
        for(int i = 0;i<nums.length;i++){
            left_sum+=nums[i];
            if(left_sum==sum){
                return i;
            }else{
                sum-=nums[i];
            }
        }
        return -1;
    }
}