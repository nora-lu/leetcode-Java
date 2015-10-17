public class BSTIterator {
  Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    pushAll(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode tmp = stack.pop();
    pushAll(tmp.right);
    return tmp.val;
  }

  private void pushAll(TreeNode node) {
    for ( ; node != null; stack.push(node), node = node.left);
  }
}
