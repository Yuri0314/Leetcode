/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int l = 0, r = s.length() - 1;
        char lc, rc;
        while (l <= r) {
            lc = s.charAt(l);
            rc = s.charAt(r);
            if (!Character.isLetterOrDigit(lc))
                ++l;
            else if (!Character.isLetterOrDigit(rc))
                --r;
            else {
                if (Character.toLowerCase(lc) != Character.toLowerCase(rc))
                    return false;
                ++l; --r;
            }
        } 
        return true;
    }
}
// @lc code=end

