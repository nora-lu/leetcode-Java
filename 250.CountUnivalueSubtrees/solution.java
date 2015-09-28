public class CountUnivalueSubtrees {
  public int countUnivalSubtrees(TreeNode root) {
    int[] count = new int[1];
    isUnival(root, count);
    return count[0];
  }

  private boolean isUnival(TreeNode root, int[] count) {
    if (root == null) { return true; }
    boolean isLeft = isUnival(root.left, count);     
    boolean isRight = isUnival(root.right, count); 
    if (isLeft && isRight) {
      if (root.left != null && root.val != root.left.val) { return false; }
      if (root.right != null && root.val != root.right.val) { return false; }
      count[0]++;
      return true;
    }
    return false;
  } 
}
