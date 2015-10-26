/* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. */

public class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) { return; }

    // find middle point
    ListNode fast = head, slow = head; 
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // 1->2->3->4->5->6, slow is at 3
    // 1->2->3->4->5, slow is at 3

    // reverse latter half of list (from slow.next)
    // 1->2->3->4->5->6 becomes 1->2->3->6->5->4
    // 1->2->3->4->5 becomes 1->2->3->5->4
    ListNode middle = slow, cur = middle.next;
    while (cur.next != null) {
      ListNode tmp = cur.next;
      cur.next = tmp.next;
      tmp.next = middle.next;
      middle.next = tmp;
    }

    // reorder the list
    ListNode h = head, r = middle.next;
    while (h != middle) {
      middle.next = r.next;
      r.next = h.next;
      h.next = r;
      h = r.next;
      r = middle.next;
    }
  }
}
