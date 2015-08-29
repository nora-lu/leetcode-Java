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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) { return 0; }
        Stack<TreeNode> tree = new Stack<>();
        TreeNode cur = root;
        int i = 0;
        while (cur != null || !tree.empty()) {
            while (cur != null) {
                tree.push(cur);
                cur = cur.left;
            }
            cur = tree.pop();
            if (++i == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return cur.val;
    }
}
