/* https://leetcode.com/problems/subtree-of-another-tree/ */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null ^ subRoot == null)
            return false;
        return sameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        else if (root == null || subRoot == null)
            return false;
        else if (root.val != subRoot.val)
            return false;
        else
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}