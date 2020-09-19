import java.util.Arrays;

/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    private char[] text1;
    private char[] text2;
    private int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1.toCharArray();
        this.text2 = text2.toCharArray();
        this.memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < memo.length; ++i)
            Arrays.fill(memo[i], -1);
        return search(text1.length() - 1, text2.length() - 1);
    }

    private int search(int pos1, int pos2) {
        if (pos1 == -1 || pos2 == -1) return 0;
        if (memo[pos1][pos2] != -1) return memo[pos1][pos2];
        memo[pos1][pos2] = 
            (text1[pos1] == text2[pos2]) ? 
            (search(pos1 - 1, pos2 - 1) + 1) : 
            Math.max(search(pos1 - 1, pos2), search(pos1, pos2 - 1));
        return memo[pos1][pos2];
    }
}
// @lc code=end

