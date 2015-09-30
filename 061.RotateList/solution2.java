public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        int size;
        for (size = 0; fast.next != null; size++) { fast = fast.next; }
        
        for (int i = size - k % size; i > 0; i--) {
            slow = slow.next;
        }
        
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
}
