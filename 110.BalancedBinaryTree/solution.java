/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) >= 0;
    }
    
    private int checkHeight(TreeNode n) {
        if (n == null) return 0;
        
        // check if left subtree is balanced
        int left = checkHeight(n.left);
        if (left == -1) return -1;
        
        // check if right subtree is balanced
        int right = checkHeight(n.right);
        if (right == -1) return -1;
        
        // check if current node is balanced
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
