public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }
    
    private int countNodes(TreeNode t) {
        if (t == null) { return 0; }
        return countNodes(t.left) + countNodes(t.right) + 1;
    }
}
