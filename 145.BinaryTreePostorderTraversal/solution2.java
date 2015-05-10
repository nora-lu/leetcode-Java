/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) { return res; }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = root;
        
        stack.push(root);
        while (!stack.empty()) {
            /**
             * We use a prev variable to keep track of the previously-traversed node. Let’s assume curr is the current node                * that’s on top of the stack. When prev is curr‘s parent, we are traversing down the tree. In this case, we try               * to traverse to curr‘s left child if available (ie, push left child to the stack). If it is not available, we                * look at curr‘s right child. If both left and right child do not exist (ie, curr is a leaf node), we print                   * curr‘s value and pop it off the stack.
             */
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
                if (cur.left != null) { stack.push(cur.left); }
                else if (cur.right != null) { stack.push(cur.right); }
            } 
            /**
             * If prev is curr‘s left child, we are traversing up the tree from the left. We look at curr‘s right child. If it              * is available, then traverse down the right child (ie, push right child to the stack), otherwise print curr‘s                * value and pop it off the stack.
             */
            else if (cur.left == prev) { // traverse up the tree from the left
                if (cur.right != null) { stack.push(cur.right); }
            } 
            /**
             * If prev is curr‘s right child, we are traversing up the tree from the right. In this case, we print curr‘s                  * value and pop it off the stack.
             */
            else { // traverse up the tree from the right
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }
}
