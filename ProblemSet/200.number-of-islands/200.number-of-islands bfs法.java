import java.util.LinkedList;
import java.util.Queue;

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
                    bfs(i, j);
                }
            }
        }
        return islandNum;
    }

    private void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<Position>();
        grid[x][y] = '0';
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position pos = queue.remove();
            int xMinus = pos.x - 1;
            int xPlus = pos.x + 1;
            int yMinus = pos.y - 1;
            int yPlus = pos.y + 1;
            if (xMinus >= 0 && grid[xMinus][pos.y] == '1') {
                queue.add(new Position(xMinus, pos.y));
                grid[xMinus][pos.y] = '0';
            }
            if (yMinus >= 0 && grid[pos.x][yMinus] == '1') {
                queue.add(new Position(pos.x, yMinus));
                grid[pos.x][yMinus] = '0';
            }
            if (xPlus < rowNum && grid[xPlus][pos.y] == '1') {
                queue.add(new Position(xPlus, pos.y));
                grid[xPlus][pos.y] = '0';
            }
            if (yPlus < colNum && grid[pos.x][yPlus] == '1') {
                queue.add(new Position(pos.x, yPlus));
                grid[pos.x][yPlus] = '0';
            }
        }
    }

    private class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
// @lc code=end

