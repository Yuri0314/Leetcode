class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j)
                ans = Math.max(ans, dfs(grid, i, j));
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int area = 1;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int k = 0; k < 4; ++k) {
            area += dfs(grid, i + di[k], j + dj[k]);
        }
        return area;
    }
}