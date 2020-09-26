import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; ++i) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i)
                    isPrimes[j] = false;
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; ++i)
            if (isPrimes[i]) ++cnt;
        return cnt;
    }
}
// @lc code=end

