class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(right)))
                 left = Math.max(left,map.get(s.charAt(right))+1);
                map.put(s.charAt(right),right);
                res = Math.max(res,right-left+1);
                right++;
        }
        return res;
    }
}