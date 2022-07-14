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
            int ele = q.poll();
            for(int it:graph[ele]){
                if(color[it] == -1){
                    q.offer(it);
                    color[it] = 1-color[ele];
                 }
                else if(color[it]==color[ele]){
                    return false;
                }
            }
        }
        return true;
        
    }
}