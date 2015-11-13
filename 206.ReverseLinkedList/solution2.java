public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) { return head; }
        ListNode before = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        return before;
    }
}
