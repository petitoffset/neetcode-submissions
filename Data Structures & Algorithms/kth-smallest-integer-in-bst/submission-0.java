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
    private int count;
    private int found;
    public int kthSmallest(TreeNode root, int k) {
        gfs(root, k);
        return found;
    }

    public void gfs(TreeNode root, int k) {
        if (root == null) return;
        if (count == k) return;
        gfs(root.left, k);
        count++;
        if (count == k) {
            found = root.val;
            return;
        }
        gfs(root.right, k);
    }
}
