class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
        for(String s:strs){
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                fmap.put(c,fmap.getOrDefault(c,0)+1);
            }
            if(map.containsKey(fmap)==false){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(fmap,list);
            }else{
                List<String> list = map.get(fmap);
                list.add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }
}