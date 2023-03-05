/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */

class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>((int) Math.pow(3, digits.length()));
        if (digits.length() == 0)
            return result;
        String[][] keypad = {{"a", "b", "c"},
                                {"d", "e", "f"},
                                {"g", "h", "i"},
                                {"j", "k", "l"},
                                {"m", "n", "o"},
                                {"p", "q", "r", "s"},
                                {"t", "u", "v"},
                                {"w", "x", "y", "z"}};
        backtrack(digits, keypad, 0, new String());
        return result;
    }
    public void backtrack(String digits, String[][] keypad, int d, String word) {
        if (d == digits.length()) {
            result.add(word);
            return;
        }
        for (int i = 0; i < keypad[digits.charAt(d) - '2'].length; i++) {
            word = word + keypad[digits.charAt(d) - '2'][i];
            backtrack(digits, keypad, d + 1, word);
            word = word.substring(0, word.length() - 1);
        }
    }
}