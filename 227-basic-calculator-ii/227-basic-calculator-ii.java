class Solution {
    public int calculate(String s) {
        if(s==null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                int val = 0;
                while(i<len && Character.isDigit(s.charAt(i))){
                    val = val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    stack.push(val);
                }else if(sign=='-'){
                    stack.push(-val);
                }else if(sign=='*'){
                    int poppedElement = stack.pop();
                    int ans = poppedElement*val;
                    stack.push(ans);
                }else if(sign=='/'){
                    int poppedElement = stack.pop();
                    int ans = poppedElement/val;
                    stack.push(ans);
                }
            }else if(s.charAt(i)!=' '){
                sign = s.charAt(i);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}