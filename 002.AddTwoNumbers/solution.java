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
        ListNode n1 = l1, n2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val; 
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val; 
                n2 = n2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (sum / 10 == 1) { cur.next = new ListNode(1); }
        return dummy.next;
    }
}
