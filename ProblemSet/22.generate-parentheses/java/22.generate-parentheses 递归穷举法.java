import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private List<String>[] memo;
    public List<String> generateParenthesis(int n) {
        memo = new ArrayList[n + 1];
        return generate(n);
    }

    private List<String> generate(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        List<String> ans = new ArrayList<String>();
        if (n == 0) 
            ans.add("");
        else {
            for (int i = 0; i < n; ++i) {
                for (String a : generate(i)) {
                    for (String b : generate(n - i - 1))
                        ans.add("(" + a + ")" + b);
                }
            }
        }
        memo[n] = ans;
        return ans;
    }
}
// @lc code=end

