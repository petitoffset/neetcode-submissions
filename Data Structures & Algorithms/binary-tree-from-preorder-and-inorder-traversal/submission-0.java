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
    Map<Integer, Integer> inMap = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        pre = preorder;
        int l = preorder.length;
        TreeNode root = build(0, l - 1, 0, l - 1);
        return root;        
    }

    TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        if (inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inMap.get(rootVal);
        int leftSize = inIndex - inStart;
        int rightSize = inEnd - inIndex;

        root.left = build(preStart + 1, preStart + leftSize, inStart, inIndex - 1);
        root.right = build(preStart + leftSize + 1, preStart + leftSize + rightSize, inIndex + 1, inEnd);

        return root;
    }
}
