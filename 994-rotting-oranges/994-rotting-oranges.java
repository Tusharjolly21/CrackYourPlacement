class Solution {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int minutes = 0;
        int total = 0;
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.offer(new int[] { i, j });
                if (grid[i][j] != 0) total++;
            }
        }
        int dx[] = { 0, 0, -1, 1 };
        int dy[] = { 1, -1, 0, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] points = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = points[0] + dx[j];
                    int y = points[1] + dy[j];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; // rot it first
                        queue.offer(new int[] { x, y });
                    }
                }
            }
            if (queue.size() != 0) {
                minutes++;
            }
        }
        return (count == total) ? minutes : -1;
    }
}
