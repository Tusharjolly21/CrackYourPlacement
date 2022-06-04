class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void solve(int index, int[] nums, List<List<Integer>> ans) {
        if(index==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<nums.length;i++){
            swap(nums,i,index);
            solve(index+1,nums,ans);
            swap(nums,i,index); /*backtracking*/
        }
    }
}
