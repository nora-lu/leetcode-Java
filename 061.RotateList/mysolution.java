public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) { return null; }
        // find size
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        k = k % size;
        if (k == 0) { return head; }
        
        tmp = head;
        for (int i = 0; i < k; i++) { tmp = tmp.next; }
        ListNode slow = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        tmp.next = head;
        slow.next = null;
        return newHead;
    }
}
