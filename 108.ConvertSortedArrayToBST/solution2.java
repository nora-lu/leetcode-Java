/* Given an array where elements are sorted in ascending order, convert it to a height balanced BST. */

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) { return null; }
        TreeNode head = new TreeNode(0);
        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>(){{ push(head); }};
        Deque<Integer> leftIndex = new LinkedList<Integer>(){{ push(0); }};
        Deque<Integer> rightIndex = new LinkedList<Integer>(){{ push(nums.length - 1); }};
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int left = leftIndex.pop();
            int right = rightIndex.pop();
            int mid = left + (right - left) / 2;
            node.val = nums[mid];
            if (left <= mid - 1) {
                node.left = new TreeNode(0);
                nodeStack.push(node.left);
                leftIndex.push(left);
                rightIndex.push(mid - 1);
            }
            if (right >= mid + 1) {
                node.right = new TreeNode(0);
                nodeStack.push(node.right);
                leftIndex.push(mid + 1);
                rightIndex.push(right);
            }
        }
        return head;
    }
}
