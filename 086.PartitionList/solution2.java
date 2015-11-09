/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode small = dummy, cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val < x) {
                if (small.next != cur.next) {  // do not move cur pointer here!!!
                    ListNode tmp = cur.next.next;
                    cur.next.next = small.next;
                    small.next = cur.next;
                    cur.next = tmp;
                } else { cur = cur.next; }
                small = small.next;                
            } else { cur = cur.next; }
        }
        return dummy.next;
    }
}
