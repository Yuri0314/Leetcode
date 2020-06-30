import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != - 1 && heights[i] < heights[stack.peek()])
                ans = Math.max(ans, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1) 
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return ans;
    }
}
// @lc code=end

