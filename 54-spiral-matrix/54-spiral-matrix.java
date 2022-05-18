class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;
        int direction = 0;
        List<Integer> ans = new ArrayList<>();
        while(top<=down && left<=right){
            if(direction==0){
                for(int i = left;i<=right;i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }else if(direction==1){
                for(int i = top;i<=down;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }else if(direction==2){
                for(int i = right;i>=left;i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }else if(direction==3){
                for(int i = down;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction+1)%4;
        }
        return ans;
        
    }
}