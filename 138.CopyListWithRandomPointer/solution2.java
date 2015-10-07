/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) { return null; }
        
        // put copied node right after the original node
        RandomListNode cur = head;
        RandomListNode next = head;
        while (cur != null) {
            next = cur.next;
            RandomListNode copied = new RandomListNode(cur.label);
            copied.next = next;
            cur.next = copied;
            cur = next;
        }
        
        // copy random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // extract copied list
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copied = dummy;
        cur = head;
        while (cur != null) {
            copied.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            copied = copied.next;
        }
        return dummy.next;
    }
}
