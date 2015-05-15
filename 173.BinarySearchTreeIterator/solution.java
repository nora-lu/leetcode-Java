/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private static TreeNode cur;
    private static Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null || !stack.empty());
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int next = cur.val;
        cur = cur.right;
        
        return next;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
