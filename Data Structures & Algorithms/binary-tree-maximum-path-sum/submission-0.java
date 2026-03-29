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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gfs(root);
        return max;  
    }

    public int gfs(TreeNode root) {
        if (root == null) return 0;
        int leftS = Math.max(0, gfs(root.left));
        int rightS = Math.max(0, gfs(root.right));
        max = Math.max(max, rightS + leftS + root.val);
        return root.val + Math.max(leftS, rightS);
    }
}
