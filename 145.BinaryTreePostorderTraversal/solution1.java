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
        
        Stack<TreeNode> parents = new Stack<>();
        TreeNode cur = root;
        TreeNode last_visited = null;
        
        while (!parents.empty() || cur != null) {
            if (cur != null) {
                parents.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode parent = parents.peek();
                if (parent.right != null && last_visited != parent.right) { cur = parent.right; }
                else {
                    res.add(parent.val);
                    last_visited = parents.pop();
                }
            }
        }
        return res;
    }
}
