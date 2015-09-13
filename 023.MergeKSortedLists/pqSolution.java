/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) { return null; }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    return n1.val - n2.val;
                }
            });
        ListNode dummy = new ListNode(0), tail = dummy;
        for (ListNode n : lists) {
            if (n != null) { q.offer(n); }
        }
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) { q.offer(tail.next); }
        }
        return dummy.next;
    }
}
