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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        gfs(root);
        return max;
    }

    public int gfs(TreeNode root) {
        if (root == null) return 0;
        int leftH = gfs(root.left);
        int rightH = gfs(root.right);
        max = Math.max(leftH + rightH, max);
        return 1 + Math.max(leftH, rightH);
    }
}
