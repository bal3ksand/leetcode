/* https://leetcode.com/problems/balanced-binary-tree/ */

class Solution {
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        maxDepth(root);
        return balanced;
    }
    public int maxDepth (TreeNode root) {
        if (root == null)
            return 0;
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        if (Math.abs(depthL - depthR) > 1)
            balanced = false;
        return Math.max(depthL, depthR) + 1;
    }
}