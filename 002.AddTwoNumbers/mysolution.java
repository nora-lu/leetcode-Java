/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else { carry = 0; }
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        if (carry == 1) { cur.next = new ListNode(carry); }
        return head.next;
    }
}
