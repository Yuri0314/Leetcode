/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) return m + n;
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) dp[i][0] = i;
        for (int i = 1; i <= n; ++i) dp[0][i] = i;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = str1[i - 1] == str2[j - 1] ? dp[i - 1][j - 1]
            : (1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])));
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

