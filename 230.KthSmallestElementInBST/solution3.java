/* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).  */

public class Solution {
    class TreeNodeWithCount {
        int val;
        int count = 1;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }
    
    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) { return null; }
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) {
            rootWithCount.count += rootWithCount.left.count; 
        }
        if (rootWithCount.right != null) {
            rootWithCount.count += rootWithCount.right.count; 
        }
        return rootWithCount;
    }
    
    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) { return -1; }
        if (rootWithCount.left != null) {
            if (k <= rootWithCount.left.count) {
                return kthSmallest(rootWithCount.left, k);
            } else if (k > rootWithCount.left.count + 1) {
                return kthSmallest(rootWithCount.right, k - rootWithCount.left.count - 1);
            } else { return rootWithCount.val; }
        } else {
            if (k == 1) { return rootWithCount.val; }
            return kthSmallest(rootWithCount.right, k - 1);
        }
    }
}
