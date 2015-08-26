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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) { return null; }
        if (start == end) {
            TreeNode n = new TreeNode(nums[start]);
            return n;
        }
        TreeNode root = new TreeNode(nums[start + (end - start) / 2]);
        root.left = sortedArrayToBST(nums, start, start + (end - start) / 2 - 1);
        root.right = sortedArrayToBST(nums, start + (end - start) / 2 + 1, end);
        return root;
    }
}
