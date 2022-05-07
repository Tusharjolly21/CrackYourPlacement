class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len-2;i++){
            if(i==0 ||(i>0 && nums[i]!=nums[i-1])){
                int low = i+1;
                int high = len-1;
                int sum = 0-nums[i];
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(nums[low]+nums[high]>sum){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        return ans;
    }
}