#
# @lc app=leetcode id=322 lang=python3
#
# [322] Coin Change
#

# @lc code=start
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        queue = []
        seen = set()
        queue.append(0)
        steps = 0
        while len(queue):
            steps += 1
            for _ in range(len(queue)):
                cur = queue.pop(0)
                for coin in coins:
                    next = cur + coin
                    if next == amount:
                        return steps
                    if next < amount and not next in seen:
                        seen.add(next)
                        queue.append(next)

        return -1

        
# @lc code=end

