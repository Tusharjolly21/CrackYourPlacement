class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<=2) return false;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=min) min = num;
            else if(num<secMin) secMin = num;
            else if(num>secMin) return true;
        }
        return false;
    }
}