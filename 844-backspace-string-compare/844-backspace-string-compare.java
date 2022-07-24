class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        String ans1 = "";
        String ans2 = "";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                stackS.push(s.charAt(i));
            }else if(!stackS.isEmpty()){
                stackS.pop();
            }
        }
        while(!stackS.isEmpty()){
            ans1+=stackS.pop();
        }
        for(int i = 0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                stackT.push(t.charAt(i));
            }else if(!stackT.isEmpty()){
                stackT.pop();
            }
        }
        while(!stackT.isEmpty()){
            ans2+=stackT.pop();
        }
        return (ans1.equals(ans2));
        
    }
}