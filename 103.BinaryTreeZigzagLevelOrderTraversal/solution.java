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
        if (root == null) { return res; }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levellist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (level % 2 == 1) {   // from left to right
                    levellist.add(t.val);
                } else {    // from right to left
                /**
                 * Pay attention: add(index, element)
                 */
                    levellist.add(0, t.val);
                }
                if (t.left != null) { q.offer(t.left); }
                if (t.right != null) { q.offer(t.right); }
            }
            level++;
            res.add(levellist);
        }
        return res;
    }
}
