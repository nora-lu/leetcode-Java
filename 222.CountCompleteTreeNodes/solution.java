public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    int h = height(root);
    return h < 0 ? 0 :
        height(root.right) == h - 1 ?  (1 << h) + countNodes(root.right) :
            (1 << h - 1) + countNodes(root.left); 
  }

  private int height(TreeNode node) {
    // The height can be found by just going left.
    return node == null ? -1 : 1 + height(node.left); 
  }
}
