class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }
        String ans = "";
        int i = -1;
        int j = -1;
        int currCount = 0;
        int desiredCount = t.length();
        HashMap<Character,Integer> mapS = new HashMap<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i<s.length()-1 && currCount<desiredCount){ /*acquiring*/
                i++;
                char ch = s.charAt(i);
                mapS.put(ch,mapS.getOrDefault(ch,0)+1);
                if(mapS.getOrDefault(ch,0)<=mapT.getOrDefault(ch,0)){
                    currCount++;
                }
                flag1 = true;
            }
            while(j<i && currCount==desiredCount){ /*releasing*/
                String res = s.substring(j+1,i+1);
                if(ans.length()==0 || res.length()<ans.length()){
                    ans = res;
                }
                j++;
                char ch = s.charAt(j);
                if(mapS.get(ch)==1){
                    mapS.remove(ch);
                }else{
                    mapS.put(ch,mapS.get(ch)-1);
                }
                if(mapS.getOrDefault(ch,0)<mapT.getOrDefault(ch,0)){
                    currCount--;
                }
                flag2 = true;
            }
            if(flag1==false && flag2==false){
                break;
            }
        }
        return ans;
    }
}