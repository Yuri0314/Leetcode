/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    private int[] coins;
    private int[] memo;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new int[amount + 1];
        return search(amount);
    }

    private int search(int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        int minAns = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = search(amount - coin);
            minAns = Math.min(minAns, tmp != -1 ? (1 + tmp) : minAns);
        }
        memo[amount] = minAns == Integer.MAX_VALUE ? -1 : minAns;
        return memo[amount];
    }
}
// @lc code=end

