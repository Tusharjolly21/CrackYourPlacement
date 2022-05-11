class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<words.length;i++){
            if(!stack.isEmpty() && words[i].equals("..")) stack.pop();
            else if(!words[i].equals("") && !words[i].equals(".") && !words[i].equals("..")){
                stack.push(words[i]);
            }
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop()).insert(0,"/");
        }
        return sb.toString();
    }
}