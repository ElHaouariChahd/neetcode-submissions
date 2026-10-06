/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int throughRoot = height(root.left) + height(root.right);
        int leftBest = diameterOfBinaryTree(root.left);
        int rightBest = diameterOfBinaryTree(root.right);
        return Math.max(throughRoot, Math.max(leftBest, rightBest));
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
