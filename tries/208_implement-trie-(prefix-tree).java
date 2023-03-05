/* https://leetcode.com/problems/implement-trie-prefix-tree/ */

class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode (boolean endOfWord) {
            this.children = new TrieNode[26];
            this.endOfWord = endOfWord;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode(false);
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] != null)
                curr = curr.children[word.charAt(i) - 'a'];
            else {
                curr.children[word.charAt(i) - 'a'] = new TrieNode(false);
                curr = curr.children[word.charAt(i) - 'a'];
            }
        }
        curr.endOfWord = true;
        return;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[word.charAt(i) - 'a'];
        }
        if (curr.endOfWord)
            return true;
        else
            return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null)
                return false;
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
    
}