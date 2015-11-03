/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.  */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, prev = null;
        int s = 0;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                s += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == null && cur.right == null && s == sum ) {
                return true;
            }
            if (cur.right != null && prev != cur.right) { cur = cur.right; }
            else {
                prev = cur;
                stack.pop();
                s -= cur.val;
                cur = null;
            }
        }
        return false;
    }
}
