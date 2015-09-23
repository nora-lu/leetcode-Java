public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) { return head; }
    ListNode slow = head, fast = head, pre = head;
    // find midpoint
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null; // split the list into two.
    ListNode n1= sortList(head);
    ListNode n2 = sortList(slow);
    return merge(n1, n2);
  }

  private ListNode merge(ListNode n1, ListNode n2) {
    if (n1 == null) { return n2; }
    if (n2 == null) { return n1; }
    ListNode dummy = new ListNode(0);
    ListNode next = dummy;
    while (n1 != null && n2 != null) {
      if (n1.val < n2.val) {
        next.next = n1;
        n1 = n1.next;
      } else {
        next.next = n2;
        n2 = n2.next;
      }
      next = next.next;
    }
    if (n1 != null) { next.next = n1; }
    else if (n2 != null) { next.next = n2; }
    return dummy.next;
  }
}
