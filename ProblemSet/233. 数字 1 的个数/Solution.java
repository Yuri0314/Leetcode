// n / (10^(k+1)) * 10^k + min(max(n mod 10^(k+1) − 10 ^k +1,0),100)，其中n′=n mod 1000
// 以求百位上的1为例有三种情况：（1）n'<100，0个1, (2) 100 <= n' < 200, n'-100+1个1, (3) n' >= 200，100个1
class Solution {
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}