public class ClosestBSTValue {
  // Recursive solution.
  public int closestValue(TreeNode root, double target) {
    TreeNode child = target < root.val ? root.left : root.right;
    if (child == null) { return root.val; }
    int closestChild = closestValue(child, target);
    return Math.abs(root.val - target) < Math.abs(closestChild - target) ?
         root.val : closestChild;
  }
}
