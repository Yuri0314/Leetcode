import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<Character>();
        for (char digit : num.toCharArray()) {
            while (k > 0 && stack.size() > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                --k;
            }
            stack.addLast(digit);
        }
        for (int i = 0; i < k; ++i) {   // 将不足删掉的k个元素从末尾删掉
            stack.removeLast();
        }
        while (!stack.isEmpty() && stack.peekFirst() == '0') stack.removeFirst();   // 去除前导0
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) 
            sb.append(ch);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

