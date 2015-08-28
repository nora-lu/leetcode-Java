public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        Stack<TreeNode> tree = new Stack<>();
        if (root.left != null) {
            if (root.right == null) { return false; }
            tree.push(root.left);
            tree.push(root.right);
        } else {
            if (root.right != null) { return false; }
        }
        
        while (!tree.empty()) {
            if (tree.size() % 2 != 0) { return false; }
            TreeNode right = tree.pop();
            TreeNode left = tree.pop();
            if (right.val != left.val) { return false; }
            
            if (left.left != null) {
                if (right.right == null) { return false; }
                tree.push(left.left);
                tree.push(right.right);
            } else {
                if (right.right != null) { return false; }
            } 
            
            if (left.right != null) {
                if (right.left == null) { return false; }
                tree.push(left.right);
                tree.push(right.left);
            } else {
                if (right.left != null) { return false; }
            } 
        }
        return true;
    }
}
