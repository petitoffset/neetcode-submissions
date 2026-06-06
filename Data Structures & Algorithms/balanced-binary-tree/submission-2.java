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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0 ? true : false;       
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightR = dfs(root.right);
        if (heightR == -1) {
            return -1;
        }
        int heightL = dfs(root.left);
        if (heightL == -1) {
            return -1;
        }

        if (Math.abs(heightR - heightL) > 1) {
            return -1;
        }

        return 1 + Math.max(heightR, heightL);
    }
}
