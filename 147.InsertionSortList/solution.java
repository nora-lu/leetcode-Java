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
        
        ListNode dummy = new ListNode(0); //new starter of the sorted list, but a dummy node
        ListNode pre = dummy; // //insert node between pre and pre.next
        ListNode current = head;
        while (current != null) {
            pre = dummy;
            //find the right place to insert
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            ListNode old = current;
            current = current.next;
            old.next = pre.next;
            pre.next = old;
        }
        return dummy.next;
    }
}
