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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        pathSum(root, sum, res, curPath);
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curPath) {
        if (root == null) { return; }
        curPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(curPath));
        } else {
            pathSum(root.left, sum - root.val, res, curPath);
            pathSum(root.right, sum - root.val, res, curPath);
        }
        curPath.remove(curPath.size() - 1);
    }
}
