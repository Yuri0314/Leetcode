class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 0) continue;
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (!set.add(num)) return false;
        }
        return max - min < 5;
    }
}