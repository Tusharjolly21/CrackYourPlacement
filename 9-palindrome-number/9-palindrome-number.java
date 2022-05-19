class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int low = 0;
        int high = str.length()-1;
        while(low<high){
            if(str.charAt(low++)!=str.charAt(high--)){
                return false;
            }
        }
    return true;        
        
        
    }
}