/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int n;
    private int count;
    public int totalNQueens(int n) {
        this.n = n;
        count = 0;
        search(0, 0, 0, 0);
        return count;
    }

    private void search(int row, int cols, int upDiagonal, int downDiagonal) {
        if (row == n) {
            ++count;
            return;
        }
        int rowBit = ((1 << n) - 1) & (~(cols | upDiagonal | downDiagonal));
        while (rowBit != 0) {
            int curBit = rowBit & (-rowBit);    // 获取最低位的1
            rowBit ^= curBit;   // 将最低位的1置为0
            search(row + 1, cols | curBit, (upDiagonal | curBit) >> 1, (downDiagonal | curBit) << 1);
        }
    }
}
// @lc code=end

