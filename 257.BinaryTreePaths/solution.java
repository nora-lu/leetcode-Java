/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) { return list; }
        if (root.left == null && root.right == null) {
            list.add("" + root.val);
        }
        if (root.left != null) {
            List<String> left = binaryTreePaths(root.left);
            for (String s : left) {
                list.add(root.val + "->" + s);
            }
        }
        if (root.right != null) {
            List<String> right = binaryTreePaths(root.right);
            for (String s : right) {
                list.add(root.val + "->" + s);
            }
        }
        return list;
    }
}
