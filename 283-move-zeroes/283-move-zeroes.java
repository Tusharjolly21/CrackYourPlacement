class Solution {
    public void moveZeroes(int[] nums) {
        int insertPoint = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0) nums[insertPoint++] = nums[i];
        }
        while(insertPoint<nums.length){
            nums[insertPoint++] = 0;
        }
    }
}