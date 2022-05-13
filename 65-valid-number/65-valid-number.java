class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        int signCount = 0;
        for(int i = 0;i<len;i++){
            char c = s.charAt(i);
            /*digit*/
            if(Character.isDigit(c)){
                hasNum = true;
            }
            /*plus and minus*/
            else if(c=='+' || c=='-'){
                if(signCount==2){
                    return false;
                }
                /*if the + or - doesnt have e and E on its i-1 index*/
                if(i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E')){
                    return false;
                }
                /*if i is at the last index*/
                if(i==s.length()-1){
                    return false;
                }
                signCount++;
            }
            /*if character is a dot*/
            else if(c=='.'){
                if(hasE || hasDot){
                    return false;
                }
                if(i==s.length()-1 && !hasNum){
                    return false;
                }
                hasDot = true;
                /*e or E*/
            }else if(c=='e' || c=='E'){
                if(hasE || !hasNum || i==s.length()-1){
                    return false;
                }
                hasE = true;
            }else{
                return false;
            }
            
        }
        return true;
    }
}