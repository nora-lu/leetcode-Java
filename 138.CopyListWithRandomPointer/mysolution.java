// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

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
        
        // key: original node, value: copied node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        // copy nodes with only labels
        RandomListNode copy = head;
        while (copy != null) {
            RandomListNode node = new RandomListNode(copy.label);
            map.put(copy, node);
            copy = copy.next;
        }
        
        // copy pointers
        copy = head;
        while (copy != null) {
            RandomListNode node = map.get(copy);
            node.next = map.get(copy.next);
            node.random = map.get(copy.random);
            copy = copy.next;
        }
        
        return map.get(head);
    }
}
