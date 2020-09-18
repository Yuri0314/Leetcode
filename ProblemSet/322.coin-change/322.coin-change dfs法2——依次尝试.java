import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    private int[] coins;
    private int ans;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        Arrays.sort(this.coins);    // 先排序
        ans = amount + 1;
        dfs(this.coins.length - 1, amount, 0);  // 从价值最大的硬币开始深搜
        return ans == (amount + 1) ? -1 : ans;
    }

    private void dfs(int index, int amount, int cnt) {
        if (amount == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = index; i >= 0; --i) {
            if ((ans - cnt) * coins[index] < amount) break; // 剪枝
            if (coins[i] <= amount)
                dfs(i, amount - coins[i], cnt + 1);
        }
    }
}
// @lc code=end

