class Solution {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, graph)) {
                    return false;
                }
            }
           
        }
         return true;
    }

    public boolean bfs(int node, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            int n = q.poll();
            for (Integer it : graph[n]) {
                if (color[it] == -1) {
                    q.offer(it);
                    color[it] = 1 - color[n];
                } else if (color[it] == color[n]) return false;
            }
        }
        return true;
    }
}
