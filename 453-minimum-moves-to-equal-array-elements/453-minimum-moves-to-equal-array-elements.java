class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int count = 0;
        for(int i = 0;i<nums.length;i++)
            min = Math.min(nums[i],min);
        
        for(int i = 0;i<nums.length;i++){
            count+=nums[i]-min;
        }
        return count;
        
        
    }
}
/**
 * Each move increments n-1 elements by 1.
 * This means every element except for one (ideally the biggest element) increases.
 * This can also be translated into only the biggest element gets decremented by 1.
 * Hence the question boils down to finding the minimum element, and how many 1 decrements all other elements need to reach that minimum.
 */