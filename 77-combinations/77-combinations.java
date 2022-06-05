class Solution {

    public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
		solve(1,n,k,ans, new ArrayList<Integer>());
		return ans;
    
}
    private void solve(int start, int n, int k, List<List<Integer>> ans, List<Integer> list) {
        if(k==0){
        ans.add(new ArrayList<>(list));
        return;
        }
        
        for(int i = start;i<=n;i++){
            list.add(i);
            solve(i+1,n,k-1,ans,list);
            list.remove(list.size()-1);
        }
    }
}
