class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, ans, new ArrayList<>(), target);
        return ans;
    }
    private void solve(int index, int[] candidates, List<List<Integer>> ans, List<Integer> list, int target) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            if(i!=index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
                list.add(candidates[i]);
                solve(i+1,candidates,ans,list,target-candidates[i]);
                list.remove(list.size()-1);
            
        }
    }
}