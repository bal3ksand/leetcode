/* https://leetcode.com/problems/longest-repeating-character-replacement/ */

class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxFreq = 0;
        char[] freqMap = new char[26];
        int result = 0;
        for (int end = 0; end < s.length(); end++) {
            freqMap[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(end) - 'A']);
            if (end - start + 1 - maxFreq > k) {
                freqMap[s.charAt(start) - 'A']--;
                start++;
            }
            result = end - start + 1;
        }
        return result;
    }
}