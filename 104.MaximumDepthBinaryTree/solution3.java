public class Solution {
    private int max = 0;
    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return max;
    }
    
    private void maxDepth(TreeNode node, int depth) {
        if (node == null) {
            max = Math.max(max, depth);
            return;
        }
        maxDepth(node.left, depth + 1);
        maxDepth(node.right, depth + 1);
    }
}
