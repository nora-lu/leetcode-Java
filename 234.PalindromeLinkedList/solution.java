/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { return true; }
        // get slow to middle point
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse second half
        ListNode start = slow.next, next = start.next;
        start.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = start;
            start = next;
            next = tmp;
        }
        slow.next = start;  // attach reversed list
        // compare first and second half
        while (start != null) {
            if (head.val != start.val) { return false; }
            head = head.next;
            start = start.next;
        }
        return true;
    }
}
