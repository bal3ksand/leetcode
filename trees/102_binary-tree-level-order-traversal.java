/* https://leetcode.com/problems/binary-tree-level-order-traversal/ */

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        preOrder(root, 0);
        return result;
    }
    public void preOrder(TreeNode node, int depth) {
        if (node == null)
            return;
        if (result.size() == depth)
            result.add(new ArrayList<Integer>());
        result.get(depth).add(node.val);
        preOrder(node.left, depth + 1);
        preOrder(node.right, depth + 1);
    }
}