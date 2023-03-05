/* https://leetcode.com/problems/kth-smallest-element-in-a-bst/ */

class Solution {
    int result;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }
    public int inOrder(TreeNode node, int k) {
        if (node == null)
            return k;
        k = inOrder(node.left, k);
        if (k == 1) {
            result = node.val;
            return 0;
        }
        else if (k == 0)
            return 0;
        return inOrder(node.right, k - 1);
    }
}