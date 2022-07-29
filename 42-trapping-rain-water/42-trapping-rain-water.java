class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int ans = 0;
        while(left<right){
            if(height[left]<=height[right]){
                if(maxLeft<=height[left]) maxLeft = height[left];
                ans+=(maxLeft-height[left]);
                left++;
            }else if(height[left]>=height[right]){
                if(maxRight<=height[right]) maxRight = height[right];
                ans+=(maxRight-height[right]);
                right--;
            }
        }
        return ans;
    }
}