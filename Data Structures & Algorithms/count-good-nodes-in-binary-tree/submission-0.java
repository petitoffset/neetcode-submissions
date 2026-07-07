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
    private int good;

    public int goodNodes(TreeNode root) {
        good = 0;
        dfs(root, -101);
        return good;       
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            good++;
            max = node.val;
        } 

        dfs(node.left, max);
        dfs(node.right, max);

        return;
    }
}
