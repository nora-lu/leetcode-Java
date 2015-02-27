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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // if (fast != null) {
        //     while (fast.next != null) {
        //         slow = slow.next;
        //         fast = fast.next;
        //     }
        //     slow.next = slow.next.next;
        // }
        // else {
        //     head = head.next;
        // }
        if (fast == null) {
            return slow.next;
        }
        while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
        slow.next = slow.next.next;
        return head;
    }
}
