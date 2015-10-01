public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) { return null; }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode t = q.poll();
      TreeNode tmp = t.left;
      t.left = t.right;
      t.right = tmp;
      if (t.left != null) { q.offer(t.left); }
      if (t.right != null) { q.offer(t.right); } 
    }
    return root;
  }
}
