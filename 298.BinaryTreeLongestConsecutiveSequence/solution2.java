public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) { return 0; }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> lens = new LinkedList<>();
        nodes.offer(root);
        lens.offer(1);
        int max = 1;
        
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int len = lens.poll();
            max = Math.max(max, len);
            if (node.left != null) {
                nodes.offer(node.left);
                lens.offer(node.left.val == node.val + 1 ? len + 1 : 1);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                lens.offer(node.right.val == node.val + 1 ? len + 1 : 1);
            }
        }
        return max;
    }
}
