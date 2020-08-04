/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                StringBuffer sb = new StringBuffer();
                while (Character.isDigit(s.charAt(idx)))
                    sb.append(s.charAt(idx++));
                stack.push(sb.toString());
                continue;
            }
            else if (Character.isLetter(c))
                stack.push(Character.toString(c));
            else if (c == ']') {
                String str = getString(stack);
                int repeat = Integer.parseInt(stack.pop());
                StringBuffer sb = new StringBuffer();
                while (repeat-- > 0)
                    sb.append(str);
                stack.push(sb.toString());
            }
            ++idx;
        }
        return getString(stack);
    }

    public String getString(Stack<String> stack) {
        Stack<String> tmpStack = new Stack<String>();
        while (!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))) {
            tmpStack.push(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        while (!tmpStack.isEmpty())
            sb.append(tmpStack.pop());
        return sb.toString();
    }
}
// @lc code=end

