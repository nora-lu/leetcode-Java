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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) { return root; }
        boolean pLeft = checkInTree(root.left, p), qLeft = checkInTree(root.left, q);
        if ((pLeft && !qLeft) || (!pLeft && qLeft)) { return root; }
        
        TreeNode sub = pLeft ? root.left : root.right;
        return lowestCommonAncestor(sub, p, q);
    }
    
    private boolean checkInTree(TreeNode root, TreeNode t) {
        if (root == null) { return false; }
        if (root == t) { return true; }
        return checkInTree(root.left, t) || checkInTree(root.right, t);
    }
}
