/* https://leetcode.com/problems/design-add-and-search-words-data-structure/ */

class WordDictionary {

    class Node {
        char value;
        List<Node> children;
        boolean terminal;
        public Node (char value, boolean terminal) {
            this.value = value;
            this.children = new LinkedList<>();
            this.terminal = terminal;
        }
        public Node add(Character c) {
            Node next = getChild(c);
            if (next == null) {
                next = new Node(c, false);
                children.add(next);
            }
            return next;
        }
        public Node getChild(Character c) {
            for (Node child : children) {
                if (child.value == c)
                    return child;
            }
            return null;
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node('.', false);
    }
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++)
            curr = curr.add(word.charAt(i));
        curr.terminal = true;
    }
    public boolean search(String word) {
        return searchRec(word, root);
    }
    public boolean searchRec(String word, Node curr) {
        if (word.isEmpty()) {
            if (curr.terminal)
                return true;
        }
        else if (word.charAt(0) == '.') {
            for (Node child : curr.children) {
                if (searchRec(word.substring(1), child))
                    return true;
            }
        }
        else {
            Node next = curr.getChild(word.charAt(0));
            if (next != null)
                return searchRec(word.substring(1), next);
        }
        return false;
    }

}
