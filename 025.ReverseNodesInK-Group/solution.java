/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 */

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, end = dummy, start, tmp;
        
        while (true) {
            // move end k steps ahead
            int i = k;
            while (i > 0 && end != null) {
                end = end.next;
                i--;
            }
            if (end == null) { break; }
            start = prev.next;
            while (prev.next != end) {
                tmp = prev.next;
                prev.next = tmp.next;
                tmp.next = end.next;
                end.next = tmp;
            }
            end = start;
            prev = start;
        }
        return dummy.next;
    }
}
