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
    public int minDepth(TreeNode root) {
        // if (root == null) return 0;
        // Queue<TreeNode> q = new LinkedList<TreeNode>();
        // q.offer(root);
        // int level = 1;
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode n = q.peek();
        //         if (n.left == null && n.right == null) return level;
        //         if (n.left != null) q.offer(n.left);
        //         if (n.right != null) q.offer(n.right);
        //         q.poll();
        //     }
        //     level++;
        // }
        if(root==null) return 0;
    
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode endOfLevel = root;
        int depth = 1;
    
        while( !queue.isEmpty() ) {
            TreeNode node = queue.remove();
            if(node.left==null && node.right==null) return depth;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null)  queue.add(node.right);
            if(node == endOfLevel) {
                endOfLevel = node.right==null ? node.left : node.right;
                depth++;
            }
        }
        return depth;
    }
}
