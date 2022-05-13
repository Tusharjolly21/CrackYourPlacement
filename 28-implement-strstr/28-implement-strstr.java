class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0;i<=len1-len2;i++){
            boolean flag = true;
            for(int j = 0;j<len2;j++){
                if(needle.charAt(j)!=haystack.charAt(j+i)){
                    flag = false;
                    break;
                }
            }
            if(flag==true) return i;
        }
        return -1;
    }
}