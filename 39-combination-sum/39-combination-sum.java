class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }

    private void solve(int index, int[] candidates, List<List<Integer>> ans, List<Integer> list, int target) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (candidates[index] <= target) {
            list.add(candidates[index]);
            solve(index, candidates, ans, list, target - candidates[index]);
            list.remove(list.size() - 1);
        }
        solve(index + 1, candidates, ans, list, target);
    }
}
