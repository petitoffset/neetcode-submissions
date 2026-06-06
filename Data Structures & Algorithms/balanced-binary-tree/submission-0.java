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
    boolean notBalanced = false;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return !notBalanced;        
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightR = dfs(root.right);
        int heightL = dfs(root.left);

        if (Math.abs(heightR - heightL) > 1) {
            notBalanced = true; 
        }

        return 1 + Math.max(heightR, heightL);
    }
}
