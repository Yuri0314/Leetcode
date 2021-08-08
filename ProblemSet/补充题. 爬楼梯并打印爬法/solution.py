class Solution:
    def climbStairs(self, n: int) -> int:
        self.n = n
        self.ans = []
        self.cur = []
        self.climb(0)
        return self.ans

    def climb(self, cur_sum: int):
        if cur_sum == self.n:
            self.ans.append(self.cur[:])
            return
        for i in (1, 2):
            self.cur.append(i)
            if cur_sum + i <= self.n:
                self.climb(cur_sum + i)
            self.cur.pop()
            