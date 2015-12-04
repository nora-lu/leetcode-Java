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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode[] cur = new ListNode[1];
        cur[0] = head;
        
        int len = size(head);
        return convert(0, len - 1, cur);
    }
    
    private TreeNode convert(int start, int end, ListNode[] cur) {
        if (start > end) { return null; }
        int mid = start + (end - start) / 2;
        TreeNode left = convert(start, mid - 1, cur);
        TreeNode root = new TreeNode(cur[0].val);
        cur[0] = cur[0].next;
        root.left = left;
        root.right = convert(mid + 1, end, cur);
        return root;
    }
    
    private int size(ListNode head) {
        int size = 0;
        for (ListNode tmp = head ; tmp != null; tmp = tmp.next) { size++; }
        return size;
    }
}
