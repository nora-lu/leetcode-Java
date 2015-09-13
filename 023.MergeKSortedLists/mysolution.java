/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lists == null || lo > hi) { return null; }
        if (lo == hi) { return lists[lo]; }
        int mid = lo + (hi - lo) / 2;
        ListNode left = merge(lists, lo, mid);
        ListNode right = merge(lists, mid + 1, hi);
        
        if (left == null) { return right; }
        if (right == null) { return left; }
        ListNode dummy = new ListNode(0), cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left == null) { cur.next = right; }
        else if (right == null) { cur.next = left; }
        return dummy.next;
    }
}
