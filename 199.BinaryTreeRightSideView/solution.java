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
        if (root == null) { return res; }
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = bfs.poll();
                if (t.left != null) { bfs.offer(t.left); }
                if (t.right != null) { bfs.offer(t.right); }
                if (i == size - 1) { res.add(t.val); }
            }
        }
        return res;
    }
}
