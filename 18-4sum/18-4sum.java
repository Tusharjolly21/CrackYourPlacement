class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int low = j+1;
                int high = len-1;
                while(low<high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }else if(sum>target){
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