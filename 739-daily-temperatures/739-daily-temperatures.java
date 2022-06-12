class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevDay = stack.pop();
                ans[prevDay] = i-prevDay;
            }
            stack.push(i);
        }
        return ans;
    }
}
