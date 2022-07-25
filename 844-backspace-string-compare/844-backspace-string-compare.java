class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        String s1 = "";
        while(!stack.isEmpty()){
            s1+=stack.pop();
        }
        for(char c:t.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        String t1 = "";
        while(!stack.isEmpty()){
            t1+=stack.pop();
        }
        return s1.equals(t1);
    }
}