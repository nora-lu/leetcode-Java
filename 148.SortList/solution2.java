/** Constant space solution. */

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        int len = getLength(head);
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur, tail, left, right;
        for (int step = 1; step < len; step <<= 1) {
            cur = dummy.next;
            tail = dummy;
            while (cur != null) {
                left = cur;
                right = split(left, step);
                cur = split(right, step);
                tail = merge(left, right, tail);
            }
        }
        return dummy.next;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) { len++; }
        return len;
    }
    
    /**
     * Divide the linked list into two lists,
     * while the first list contains first n ndoes
     * return the second list's head
     */
    private ListNode split(ListNode head, int n) {
        for (int i = 1; i < n && head != null; i++) { head = head.next; }
        if (head == null) { return null; }
        ListNode next = head.next;
        head.next = null;
        return next;
    }
    
    /**
      * merge the two sorted linked list l1 and l2,
      * then append the merged sorted linked list to the node head
      * return the tail of the merged sorted linked list
     */
    private ListNode merge(ListNode l1, ListNode l2, ListNode head) {
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2); 
        while (cur.next != null) { cur = cur.next; }
        return cur;
    }
}
