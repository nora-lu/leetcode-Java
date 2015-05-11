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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) { return res; }
        
        Stack<TreeNode> helper = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        helper.push(root);
        while (!helper.empty()) {
            TreeNode n = helper.pop();
            output.push(n);
            if (n.left != null) { helper.push(n.left); }
            if (n.right != null) { helper.push(n.right); }
        }
        
        while (!output.empty()) {
            res.add(output.pop().val);
        }
        return res;
    }
}
