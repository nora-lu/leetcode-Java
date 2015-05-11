public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) { return true; }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null && cur.val <= prev.val) { return false; }
            prev = cur;
            cur = cur.right;
        }
        return true;
    }
}
