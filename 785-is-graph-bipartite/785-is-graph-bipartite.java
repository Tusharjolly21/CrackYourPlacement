class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i]==-1){
                if(!isBfsBipartite(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBfsBipartite(int[][] graph,int node,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;
        while(!q.isEmpty()){
            int k = q.poll();
            for(int it : graph[k]){
                if(color[it] == -1){
                    q.offer(it);
                    color[it] = 1 - color[k];
                }
                else if(color[it] == color[k]){
                    return false;
                }
            }
        }
        return true;
    }
}