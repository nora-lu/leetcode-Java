public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> sums = new LinkedList<>();
        nodes.offer(root);
        sums.offer(root.val);
        
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int nodeSum = sums.poll();
            if (node.left == null && node.right == null && nodeSum == sum) {
                return true;
            }
            if (node.left != null) {
                nodes.offer(node.left);
                sums.offer(nodeSum + node.left.val);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                sums.offer(nodeSum + node.right.val);
            }
        }
        return false;
    }
}
