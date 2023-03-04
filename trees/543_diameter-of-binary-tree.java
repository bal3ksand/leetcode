/* https://leetcode.com/problems/diameter-of-binary-tree/ */

class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }
    public int helper (TreeNode root) {
        if (root == null)
            return 0;
        int heightL = helper(root.left);
        int heightR = helper(root.right);
        maxDiameter = Math.max(maxDiameter, heightL + heightR);
        return Math.max(heightL, heightR) + 1;
    }
}