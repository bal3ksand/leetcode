/* https://leetcode.com/problems/longest-substring-without-repeating-characters/ */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        int length = 0;
        int result = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!seen.containsKey(c) || seen.get(c) < l) {
                seen.put(c, r);
                length++;
                result = Math.max(result, length);
            }
            else {
                l = seen.get(c) + 1;
                length = r - l + 1;
                seen.put(c, r);
            }
            r++;
        }
        return result;
    }
}