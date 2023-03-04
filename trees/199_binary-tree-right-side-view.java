/* https://leetcode.com/problems/binary-tree-right-side-view/ */

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        preOrder(root, 0);
        return result;
    }
    public void preOrder(TreeNode node, int height) {
        if (node == null)
            return;
        if (height == result.size())
            result.add(node.val);
        preOrder(node.right, height + 1);
        preOrder(node.left, height + 1);
    }
}