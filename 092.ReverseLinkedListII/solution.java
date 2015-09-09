/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // move prev to one node before position m.
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next, next = cur.next, end = cur;
        for (int i = m; i < n; i++) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        prev.next = cur;
        end.next = next;
        return dummy.next;
    }
}
