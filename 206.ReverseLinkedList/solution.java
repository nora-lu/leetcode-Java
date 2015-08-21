/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode newHead = reverseList(head.next);
        ListNode n = newHead;
        while (n.next != null) {
            n = n.next;
        }
        n.next = head;
        head.next = null;
        return newHead;
    }
}
