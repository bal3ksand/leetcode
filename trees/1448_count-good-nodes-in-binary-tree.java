/* https://leetcode.com/problems/count-good-nodes-in-binary-tree/ */

class Solution {
    int result = 0;
    public int goodNodes(TreeNode root) {
        preOrder(root, root.val);
        return result;
    }
    public void preOrder(TreeNode node, int pathMax) {
        if (node == null)
            return;
        if (node.val >= pathMax)
            result += 1;
        preOrder(node.left, Math.max(pathMax, node.val));
        preOrder(node.right, Math.max(pathMax, node.val));
    }
}