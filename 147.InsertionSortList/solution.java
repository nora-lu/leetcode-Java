/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        
        while (head != null) {
            ListNode n = newHead;
            while (n.next != null && n.next.val < head.val) {
                n = n.next;
            }
            ListNode old = head;
            head = head.next;
            old.next = n.next;
            n.next = old;
        }
        return newHead.next;
    }
}
