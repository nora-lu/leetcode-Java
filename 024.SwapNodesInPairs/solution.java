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
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;  // delete next node
            next.next = prev.next;  // insert next at prev.next position
            prev.next = next;  
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
