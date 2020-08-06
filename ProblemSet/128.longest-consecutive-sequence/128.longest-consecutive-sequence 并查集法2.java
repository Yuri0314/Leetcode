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
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1))
                uf.union(i, map.get(nums[i] + 1));
            if (map.containsKey(nums[i] - 1))
                uf.union(i, map.get(nums[i] - 1));
        }
        return uf.getMaxCount();
    }

    class UnionFind {
        private int[] unionSet;
        private int[] countSet;
        private int maxCount;
        public UnionFind(int length) {
            unionSet = new int[length];
            countSet = new int[length];
            for (int i = 0; i < length; ++i) {
                unionSet[i] = i;
                countSet[i] = 1;
            }
            maxCount = length > 0 ? 1 : 0;
        }

        public int getRoot(int i) {
            while (i != unionSet[i]) {
                unionSet[i] = unionSet[unionSet[i]];
                i = unionSet[i];
            }
            return i;
        }

        public void union(int a, int b) {
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if (rootA == rootB) return;
            if (countSet[rootA] < countSet[rootB]) {
                unionSet[rootA] = unionSet[rootB];
                countSet[rootB] += countSet[rootA];
                maxCount = Math.max(maxCount, countSet[rootB]);
            }
            else {
                unionSet[rootB] = unionSet[rootA];
                countSet[rootA] += countSet[rootB];
                maxCount = Math.max(maxCount, countSet[rootA]);
            }
        }

        public int getMaxCount() {
            return this.maxCount;
        }
    }
}
// @lc code=end

