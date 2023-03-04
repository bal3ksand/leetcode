/* https://leetcode.com/problems/permutation-in-string/ */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
            
        int[] freqTarget = new int[26];
        int[] freqWindow = new int[26];
        
        for (int i = 0; i < s1.length(); i++)
            freqTarget[s1.charAt(i) - 'a']++;

        for (int i = 0; i < s1.length(); i++)
            freqWindow[s2.charAt(i) - 'a']++;

        int l = 0;
        int r = s1.length() - 1;
        while (r < s2.length()) {
            boolean isValid = true;
            for (int i = l; i <= r; i++) {
                if (freqWindow[s2.charAt(i) - 'a'] > freqTarget[s2.charAt(i) - 'a']) {
                    while (l < i + 1) {
                        freqWindow[s2.charAt(l) - 'a']--;
                        l++;
                    }
                    isValid = false;
                }
            }
            if (isValid)
                return true;
            while (r < s2.length() - 1 && r - l + 1 < s1.length()) {
                r++;
                freqWindow[s2.charAt(r) - 'a']++;
            }
            if (r - l + 1 < s1.length())
                r++;
        }  
        return false;
    }
}