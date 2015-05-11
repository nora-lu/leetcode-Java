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
    public boolean isValidBST(TreeNode root) {
        // be careful with node of Integer.MIN/MAX Value
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) { return true; }
        if (node.val >= max || node.val <= min) { return false; }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
