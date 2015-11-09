/* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) { cur = cur.next; }
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
