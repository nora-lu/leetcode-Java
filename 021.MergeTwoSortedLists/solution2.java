/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            }
            else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 != null) tail.next = p1;
        if (p2 != null) tail.next = p2;
        return dummy.next;
    }
}
