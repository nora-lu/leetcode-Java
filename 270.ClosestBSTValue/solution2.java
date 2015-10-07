public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = (Math.abs(root.val - target) < Math.abs(closest - target)) ? root.val : closest;
            root = root.val > target ? root.left : root.right;
        }
        return closest;
    }
}
