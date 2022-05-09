class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right_boundary = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1); /*pushing the last element into the stack to check with previous elements*/
        right_boundary[n-1] = n; /*last element boundary is length of array*/
        for(int i = n-2;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()==0){
                right_boundary[i] = n;
            }else{
                right_boundary[i] = stack.peek();
            }
            stack.push(i);
        }
        
        int[] left_boundary = new int[n];
        stack = new Stack<>();
        stack.push(0); /*pushing the first element into the stack to check with previous elements*/
        left_boundary[0] = -1; /*left boundary of 1st element will be -1*/
        for(int i = 1;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()==0){
                left_boundary[i] = -1;
            }else{
                left_boundary[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for(int i = 0;i<n;i++){
            int width = right_boundary[i]-left_boundary[i]-1;
            maxArea = Math.max(heights[i]*width,maxArea);
        }
        return maxArea;
        
        
    }
}