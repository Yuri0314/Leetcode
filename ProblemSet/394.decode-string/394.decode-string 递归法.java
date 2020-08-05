/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    String str;
    int pos;
    public String decodeString(String s) {
        str = s;
        pos = 0;
        return getString();
    }

    public String getString() {
        StringBuffer ans = new StringBuffer();
        int repeat = 0;
        while (pos < str.length()) {
            char ch = str.charAt(pos);
            if (Character.isDigit(ch)) 
                repeat = repeat * 10 + ch - '0';
            else if (ch == '[') {
                ++pos;
                String tmp = getString();
                for (;repeat > 0; --repeat) ans.append(tmp);
            }
            else if (Character.isLetter(ch))
                ans.append(Character.toString(ch));
            else break;
            ++pos;
        }
        return ans.toString();
    }
}
// @lc code=end

