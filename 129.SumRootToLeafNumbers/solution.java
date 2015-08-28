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
    public int sumNumbers(TreeNode root) {
        if (root == null) { return 0; }
        
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> vals = new LinkedList<>();
        nodes.offer(root);
        vals.offer(root.val);
        
        int sum = 0;
        while (!nodes.isEmpty()) {
            TreeNode n = nodes.poll();
            Integer val = vals.poll();
            if (n.left == null && n.right == null) {    // leaf node
                sum += val;
            } 
            if (n.left != null) {
                nodes.offer(n.left);
                vals.offer(val * 10 + n.left.val);
            }
            if (n.right != null) {
                nodes.offer(n.right);
                vals.offer(val * 10 + n.right.val);
            }
        }
        return sum;
    }
}
