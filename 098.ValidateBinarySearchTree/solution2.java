public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) { return true; }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long prev_value = Long.MIN_VALUE;
        
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= prev_value) { return false; }
            prev_value = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
