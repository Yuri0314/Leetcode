// 时间复杂度O(N^2)
/**
 * temp = matrix[row][col]
 * matrix[row][col] = matrix[n−col−1][row]
 * matrix[n−col−1][row] = matrix[n−row−1][n−col−1]
 * matrix[n−row−1][n−col−1] = matrix[col][n−row−1]
 * matrix[col][n−row−1] = temp
 * 当 n 为偶数时，我们需要枚举 n^2 / 4 = (n/2)×(n/2) 个位置
 * 当 nn 为奇数时，由于中心的位置经过旋转后位置不变，我们需要枚举 (n^2-1) / 4 = ((n−1)/2)×((n+1)/2) 个位置
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int tmp = matrix[i][j];
                int a = n - j - 1, b = n - i - 1;
                matrix[i][j] = matrix[a][i];
                matrix[a][i] = matrix[b][a];
                matrix[b][a] = matrix[j][b];
                matrix[j][b] = tmp;
            }
        }
    }
}