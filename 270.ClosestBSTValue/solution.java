public class ClosestBSTValue {

  // Iterative solution.
  public int closestValue(TreeNode root, double target) {
    if (root == null) { return Integer.MAX_VALUE; }
    TreeNode tmp = root;
    int closest = tmp.val;
    while (tmp != null) {
      if (tmp.val == target) { return tmp.val; }
      if (Math.abs(tmp.val - target) < Math.abs(closest - target)) { closest = tmp.val; }
      if (target < tmp.val) { tmp = tmp.left; }
      else { tmp = tmp.right; }  
    }
    return closest;
  }


  // Recursive solution.
  public int closestValue(TreeNode root, double target) {
    TreeNode child = target < root.val ? root.left : root.right;
    if (child == null) { return root.val; }
    int closestChild = closestValue(child, target);
    return Math.abs(root.val - target) < Math.abs(closestChild - target) ?
         root.val : closestChild;
  }
}
