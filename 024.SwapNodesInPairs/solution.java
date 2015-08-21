/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode next = head.next;
        while (next != null) {
            ListNode tmp = next.next;
            prev.next = next;
            next.next = head;
            head.next = tmp;
            prev = head;
            if (prev.next == null || prev.next.next == null) { break; }
            else {
                head = head.next;
                next = head.next;
            }
        }
        return dummy.next;
    }
}
