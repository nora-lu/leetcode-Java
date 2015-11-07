/* Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return null; }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) { q.offer(node.left); }
            if (node.right != null) { q.offer(node.right); }
            sb.append(",");
            sb.append(node.left != null ? node.left.val : "#");
            sb.append(",");
            sb.append(node.right != null ? node.right.val : "#");
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == '#') {
            sb.deleteCharAt(i);
            sb.deleteCharAt(i - 1);
            i -= 2;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) { return null; }
        String[] arr = data.split(",");
        int len = arr.length, count = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        count++;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (count < len) {
                String left = arr[count++];
                if (!left.equals("#")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    q.offer(node.left);
                }
            }
            if (count < len) {
                String right = arr[count++];
                if (!right.equals("#")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
