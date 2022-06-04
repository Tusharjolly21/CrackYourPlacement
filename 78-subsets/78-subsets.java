class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void subsetHelper(int index, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        /*INCLUDED*/
        list.add(nums[index]);
        subsetHelper(index + 1, nums, ans, list);
        /*delete the included element and add the next one NOT INCLUDED*/
        list.remove(list.size() - 1);
        subsetHelper(index + 1, nums, ans, list);
    }
}
