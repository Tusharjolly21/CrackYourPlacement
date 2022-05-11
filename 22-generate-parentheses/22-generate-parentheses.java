class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans,"",0,0,n);
        return ans;
    }
    private void generate(List<String> ans,String curr,int opening,int closing,int max){
        if(curr.length()==max*2){
            ans.add(curr);
            return;
        }
        if(opening<max){
             generate(ans,curr+"(",opening+1,closing,max);
        }
        if(closing<opening){
             generate(ans,curr+")",opening,closing+1,max);
        }
    }
}