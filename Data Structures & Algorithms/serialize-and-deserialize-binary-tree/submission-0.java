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

public class Codec {
    List<Integer> nodes;
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();  
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null ");
            return;
        }
        sb.append(root.val).append(" ");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        nodes = parseStr(data);
        index = 0;
        return dfsBuild();
    }

    public List<Integer> parseStr(String s) {
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        while (pos < s.length()) {
            if (s.charAt(pos) == 'n') {
                list.add(null);
                pos = pos + 5;
                continue;
            }
            int sign = 1;
            if (s.charAt(pos) == '-') {
                sign = -1;
                pos++;
            }
            int num = 0;
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                num = num * 10 + (s.charAt(pos) - '0');
                pos++;
            }
            pos++;
            list.add(sign * num);
        }
        return list;
    }

    public TreeNode dfsBuild() {
        if (nodes.get(index) == null) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(nodes.get(index));
        index++;
        node.left = dfsBuild();
        node.right = dfsBuild();
        return node;
    }
}
