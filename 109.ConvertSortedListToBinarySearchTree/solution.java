/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = findSize(head);
        return sortedListToBST(0, len - 1);
    }
    
    private int findSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) { return null; }   // already include the case when head is null
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.right = right;
        return root;
    }
}
