import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int cur = 0; cur < height.length; ++cur) {
            while (!stack.empty() && height[cur] > height[stack.peek()]) {
                int tmp = stack.pop();
                if (stack.empty()) break;
                int width = cur - stack.peek() - 1;
                int bounded_height = Math.min(height[cur], height[stack.peek()]) - height[tmp];
                sum += width * bounded_height;
            }
            stack.push(cur);
        }
        
        return sum;
    }
}
// @lc code=end

