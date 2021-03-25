import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private int n;
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<String>();
        backtrace(new StringBuilder(), 0, 0);
        return ans;
    }

    private void backtrace(StringBuilder cur, int left_num, int right_num) {
        if (cur.length() == 2 * this.n) {
            this.ans.add(cur.toString());
            return;
        }
        if (left_num < this.n) {
            cur.append('(');
            backtrace(cur, left_num + 1, right_num);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right_num < left_num) {
            cur.append(')');
            backtrace(cur, left_num, right_num + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
// @lc code=end

