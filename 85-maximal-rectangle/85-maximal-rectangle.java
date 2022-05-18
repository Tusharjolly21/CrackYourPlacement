class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 ||matrix[0].length==0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max_rectangle = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j]=='0') heights[j] = 0;
                else heights[j]+=matrix[i][j]-'0';
            }
            max_rectangle = Math.max(max_rectangle,maxAreaInHistogram(heights));
        }
        return max_rectangle;
    }
    private int maxAreaInHistogram(int[] heights){
        int n = heights.length;
        int[] NSR = NSR(heights);
        int[] NSL = NSL(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int width = NSR[i]-NSL[i]-1;
            maxArea = Math.max(maxArea,heights[i]*width);
        }
        return maxArea;
    }
    private int[] NSR(int[] heights){
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
        return right_boundary;
    }
    private int[] NSL(int[] heights){
        int n = heights.length;
        int[] left_boundary = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);/*pushing the first element into the stack to check with previous elements*/
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
        return left_boundary;
    } 
}