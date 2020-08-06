import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            uf.union(num, num + 1);
        }
        return uf.getMaxCount();
    }

    class UnionFind {
        private Map<Integer, Integer> unionSet = new HashMap<Integer, Integer>();
        private Map<Integer, Integer> countSet = new HashMap<Integer, Integer>();
        private int maxCount;
        public UnionFind(int[] nums) {
            for (int num : nums) {
                unionSet.put(num, num);
                countSet.put(num, 1);
            }
            maxCount = nums.length > 0 ? 1 : 0;
        }

        public int getRoot(int num) {
            if (num == unionSet.get(num))
                return num;
            else {
                unionSet.put(num, getRoot(unionSet.get(num)));
                return unionSet.get(num);
            }
        }

        public void union(int a, int b) {
            if (!unionSet.containsKey(a) || !unionSet.containsKey(b)) return;
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if (rootA == rootB) return;
            int newCount = countSet.get(rootA) + countSet.get(rootB);
            if (countSet.get(rootA) < countSet.get(rootB)) {
                unionSet.put(rootA, rootB);
                countSet.put(rootB, newCount);
            }
            else {
                unionSet.put(rootB, rootA);
                countSet.put(rootA, newCount);
            }
            maxCount = Math.max(maxCount, newCount);
        }

        public int getMaxCount() {
            return this.maxCount;
        }
    }
}
// @lc code=end

