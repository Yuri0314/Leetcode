/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int[][] ans = new int[][]{{1, 0}, {0, 1}};
        int[][] A = new int[][]{{1, 1}, {1, 0}};
        int n = N - 1;
        while (n > 0) {
            if ((n & 1) == 1) matrixMul(ans, A);
            matrixMul(A, A);
            n >>= 1;
        }
        return ans[0][0];
    }

    private void matrixMul(int[][] A, int[][] B) {
        int x11 = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int x12 = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int x21 = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int x22 = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x11;
        A[0][1] = x12;
        A[1][0] = x21;
        A[1][1] = x22;
    }
}
// @lc code=end

