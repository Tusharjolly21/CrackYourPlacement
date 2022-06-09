class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        
        for(int[] point:points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2]; /*2 because of x and y coordinate only two given*/
        while(k-->0){
            ans[k] = maxHeap.poll();
        }
        return ans;
    }
}