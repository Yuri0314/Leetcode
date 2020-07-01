import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    private Deque<Integer> deque = new ArrayDeque();

    void push(int x) {
        while (!deque.isEmpty() && deque.getLast() < x)
            deque.removeLast();
        deque.addLast(x);
    }

    void pop(int x) {
        if (!deque.isEmpty() && deque.getFirst() == x)
            deque.removeFirst();
    }

    int getMax() { return deque.getFirst(); }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0, p = 0; i < nums.length; ++i) {
            push(nums[i]);
            if (i >= k - 1) {
                ans[p++] = getMax();
                pop(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
// @lc code=end

