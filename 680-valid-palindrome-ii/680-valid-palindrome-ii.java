class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return helperFn(s,i+1,j) || helperFn(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean helperFn(String s, int i,int j){
        int a = i;
        int b = j;
        while(a<b){
            if(s.charAt(a++)!=s.charAt(b--)){
                return false;
            }
        }
        return true;
    }
}