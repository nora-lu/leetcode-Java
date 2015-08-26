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
        if (nums == null || nums.length == 0) { return null; }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) { return null; }
        int mid = lo + (hi - lo) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedArrayToBST(nums, lo, mid - 1);
        n.right = sortedArrayToBST(nums, mid + 1, hi);
        return n;
    }
}
