class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch); /*pushing the opening brackets*/
            }else{
                if(stack.isEmpty()) return false; /*if nothing gets pushed return false means either the string is empty or theres no opening brackets for closed ones*/
                char c = stack.pop(); /*poping char '(' '[' '{' from the stack*/
                if(c=='(' && ch==')' || c=='{' && ch=='}' || c=='[' && ch==']') continue; /*And checking if its equal to the closing ones or not*/ 
                else return false;
            }
        }
        return stack.isEmpty(); /*if all the characters have the opening and closing brackets and they match means the stack will be empty*/
    }
}