/* Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2. */

public class Solution {
  public int longestConsecutive(TreeNode root) {
    return helper(root, null, 0);
  }

  private int helper(TreeNode node, TreeNode parent, int len) {
    if (node == null) { return len; }
    if (parent != null && node.val == parent.val + 1) {
      len++;
    } else { len = 1; }
    return Math.max(len, Math.max(helper(node.left, node, len),
        helper(node.right, node, len)));
  }
}
