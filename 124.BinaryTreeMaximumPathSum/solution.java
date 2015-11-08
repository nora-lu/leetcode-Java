/* Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.  */

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
    public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    
    private int maxPathSum(TreeNode node, int[] max) {
        if (node == null) { return 0; }
        int left = Math.max(maxPathSum(node.left, max), 0);  // if negative
        int right = Math.max(maxPathSum(node.right, max), 0);
        max[0] = Math.max(max[0], left + right + node.val);  // once goes down in right subtree, cannot be passed to parent
        return Math.max(left, right) + node.val; 
    }
}
}
