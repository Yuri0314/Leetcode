/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    private int rowNum;
    private int colNum;
    private char[][] board;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        rowNum = board.length;
        colNum = board[0].length;
        this.board = board;
        for (int i = 0; i < rowNum; ++i) {
            dfs(i, 0);
            dfs(i, colNum - 1);
        }
        for (int j = 0; j < colNum; ++j) {
            dfs(0, j);
            dfs(rowNum - 1, j);
        }
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= rowNum || y < 0 || y >= colNum || board[x][y] != 'O') return;
        board[x][y] = '-';
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x - 1, y);
    }
}
// @lc code=end

