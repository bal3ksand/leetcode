/* https://leetcode.com/problems/word-search/ */

class Solution {
    boolean exists;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!exists)
                    backtrack(board, word, new boolean[board.length][board[0].length], new String(), i, j);
            }
        }
        return exists;
    }
    public void backtrack(char[][] board, String word, boolean[][] seen, String candidate, int i, int j) {
        if (exists)
            return;
        seen[i][j] = true;
        candidate += Character.toString(board[i][j]);
        if (candidate.equals(word)) {
            exists = true;
            return;
        }
        else if (candidate.charAt(candidate.length() - 1) != word.charAt(candidate.length() - 1))
            return;
        if (i > 0 && !seen[i - 1][j])
            backtrack(board, word, seen, candidate, i - 1, j);
        if (i < board.length - 1 && !seen[i + 1][j])
            backtrack(board, word, seen, candidate, i + 1, j);
        if (j > 0 && !seen[i][j - 1])
            backtrack(board, word, seen, candidate, i, j - 1);
        if (j < board[0].length - 1 && !seen[i][j + 1])
            backtrack(board, word, seen, candidate, i, j + 1);
        seen[i][j] = false;
    }
}