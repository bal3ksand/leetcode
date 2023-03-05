/* https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ */

class Solution {
    int preorderIdx;
    Map<Integer, Integer> inorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        inorderIdx = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inorderIdx.put(inorder[i], i);
        return buildSubtree(preorder, 0, inorder.length - 1);
    }
    public TreeNode buildSubtree(int[] preorder, int l, int r) {
        if (l > r)
            return null;
        int rootValue = preorder[preorderIdx];
        TreeNode root = new TreeNode(rootValue);
        preorderIdx++;
        root.left = buildSubtree(preorder, l, inorderIdx.get(rootValue) - 1);
        root.right = buildSubtree(preorder, inorderIdx.get(rootValue) + 1, r);
        return root;
    }
}