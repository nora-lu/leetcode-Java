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
    public void flatten(TreeNode root) {
        if (root == null) { return; }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (n.right != null) { stack.push(n.right); }
            if (n.left != null) { stack.push(n.left); }
            if (!stack.empty()) {
                n.right = stack.peek();
            }
            // DO NOT FORGET THIS!
            n.left = null;
        }
    }
}
