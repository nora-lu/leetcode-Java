/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (q.size() != 0) {
            int size = q.size(); // because size of queue is changing
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            list.add(0, subList);
        }
        return list;
    }
}
