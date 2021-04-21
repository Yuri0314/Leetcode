// 时间复杂度O(N^2)
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