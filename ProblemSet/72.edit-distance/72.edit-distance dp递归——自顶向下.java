/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    private char[] str1;
    private char[] str2;
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        str1 = word1.toCharArray();
        str2 = word2.toCharArray();
        memo = new int[str1.length][str2.length];
        return search(str1.length - 1, str2.length - 1);
    }
    
    private int search(int pos1, int pos2) {
        if (pos1 < 0) return pos2 + 1;
        if (pos2 < 0) return pos1 + 1;
        if (memo[pos1][pos2] != 0) return memo[pos1][pos2];
        memo[pos1][pos2] = str1[pos1] == str2[pos2] ? search(pos1 - 1, pos2 - 1) 
            : (1 + Math.min(search(pos1, pos2 - 1), Math.min(search(pos1 - 1, pos2), search(pos1 - 1, pos2 - 1))));
        return memo[pos1][pos2];
    }
}
// @lc code=end

