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
        ListNode headOfRest = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = headOfRest;
        return newHead;
    }
}
