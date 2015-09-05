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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode cur, int curDepth) {
        if (cur == null) { return; }
        if (curDepth == res.size()) {
            res.add(cur.val);
        }
        helper(res, cur.right, curDepth + 1);
        helper(res, cur.left, curDepth + 1);
    }
}
