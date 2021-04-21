class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int first = 0, second = 1, cur = 0;
        for (int i = 1; i <= n; ++i) {
            cur = 0;
            if (s.charAt(i - 1) != '0') cur += second;
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) cur += first;
            first = second;
            second = cur;
        }
        return cur;
    }
}