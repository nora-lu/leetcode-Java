/**
 * 不符合constant extra space！
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // in level traversal
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (queue.peek() != null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode x = queue.poll();
                x.next = (i == size - 1) ? null : queue.peek();
                queue.add(x.left);
                queue.add(x.right);
            }
        }
    }
}
