public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    int h = height(root);
    int nodes = 0;
    while (root != null ) {
      if (height(root.right) == h - 1) {  // last node is in right subtree
        nodes += 1 << h;
        root = root.right;
      } else {  // last node is in left subtree
        nodes += 1 << h - 1;
        root = root.left;       
      }
      h--;
    }
    return nodes;
  }
  
  private int height(TreeNode node) {
    return node == null ? -1 : 1 + height(node.left);
  }
}
