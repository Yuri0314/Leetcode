import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    private int[] coins;
    private int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        Arrays.sort(this.coins);    // 先排序
        dfs(this.coins.length - 1, amount, 0);  // 从价值最大的硬币开始深搜
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int index, int amount, int cnt) {
        if (amount == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (index < 0) return;
        for (int i = amount / coins[index]; i >= 0 && i + cnt < ans; --i) { // 通过判断条件剪枝
            dfs(index - 1, amount - i * coins[index], cnt + i);
        }
    }
}
// @lc code=end

