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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(res, root, 0);
        return res;
    }
    
    private void recurse(List<List<Integer>> res, TreeNode t, int level) {
        if (t == null) { return; }
        if (res.size() <= level) {
            /**
             *  Nice idea: we need to insert at index 0. LinkedList gives O(1) performance.
             */
            List<Integer> newlist = new LinkedList<>();
            res.add(newlist);
        } 
        List<Integer> list = res.get(level);
        if (level % 2 == 0) {
            list.add(t.val);
        } else {
            list.add(0, t.val);
        }
        recurse(res, t.left, level + 1);
        recurse(res, t.right, level + 1);
    }
}
