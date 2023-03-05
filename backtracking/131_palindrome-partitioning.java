/* https://leetcode.com/problems/palindrome-partitioning/ */

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        List<String> p = new ArrayList<>();
        p.add(s.substring(0, 1));
        backtrack(s, 1, p);
        return result;
    }
    public void backtrack(String s, int i, List<String> p) {
        if (i == s.length()) {
            if (isPalindrome(p.get(p.size() - 1)))
                result.add(new ArrayList<>(p));
            return;
        }
        if (isPalindrome(p.get(p.size() - 1))) {
            p.add(s.substring(i, i + 1));
            backtrack(s, i + 1, p);
            p.remove(p.size() - 1);
        }
        String candidate = p.get(p.size() - 1) + s.substring(i, i + 1);
        p.set(p.size() - 1, candidate);
        backtrack(s, i + 1, p);
        p.set(p.size() - 1, p.get(p.size() - 1).substring(0, candidate.length() - 1));
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}