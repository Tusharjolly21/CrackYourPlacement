class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] all : dp) Arrays.fill(all, -1);

        return totalPath(0, 0, triangle, dp);
    }

    private int totalPath(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if (i == triangle.size()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + totalPath(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + totalPath(i + 1, j + 1, triangle, dp);
        dp[i][j] = Math.min(down, diagonal);
        return dp[i][j];
    }
}
