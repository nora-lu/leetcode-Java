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
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    
    private void helper(TreeNode root, String path, List<String> res) {
        if (root == null) { return; }
        if (root.left == null && root.right == null) {  // reach a leaf
            res.add(path + root.val);
        }
        if (root.left != null) { helper(root.left, path + root.val + "->", res); }
        if (root.right != null) { helper(root.right, path + root.val + "->", res); }
    }
}
