class Solution {
    String keys[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private void helper(int index, String digits,String temp,List<String> ans) {
        if(index==digits.length()){
            ans.add(temp);
            return;
        }
        for(int i = 0;i<keys[digits.charAt(index)-'0'].length();i++){
            char ch = keys[digits.charAt(index)-'0'].charAt(i);
            helper(index+1,digits,temp+ch,ans);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length()==0) return ans;
        helper(0,digits,"",ans);
        return ans;
        
    }
}
