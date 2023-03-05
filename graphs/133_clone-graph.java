/* https://leetcode.com/problems/clone-graph/ */

class Solution {
    Node[] clone;
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        clone = new Node[101];
        return dfs(node);
    }
    public Node dfs(Node node) {
        Node copy;
        if (clone[node.val] == null) {
            copy = new Node(node.val, new ArrayList<>(node.neighbors.size()));
            clone[node.val] = copy;
            for (Node child : node.neighbors)
                copy.neighbors.add(dfs(child));
        }
        else
            copy = clone[node.val];
        return copy;
    }
}