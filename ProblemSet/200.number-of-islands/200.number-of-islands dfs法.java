/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private int rowNum;
    private int colNum;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        rowNum = grid.length;
        colNum = grid[0].length;
        this.grid = grid;

        int islandNum = 0;

        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (grid[i][j] == '1') {
                    ++islandNum;
                    dfs(i, j);
                }
            }
        }
        return islandNum;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= rowNum || y < 0 || y >= colNum || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x - 1, y);
    }
}
// @lc code=end

