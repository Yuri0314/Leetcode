class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = -1, ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) > l) {
                l = map.get(c);
                map.put(c, i);
            }
            else {
                map.put(c, i);
                ans = Math.max(ans, i - l);
            }
        }
        return ans;
    }
}