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
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (map.containsKey(tmp)) { break; }
            map.put(tmp, new RandomListNode(tmp.label));
        }
        
        // copy pointers
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next) {
            RandomListNode copy = map.get(tmp);
            copy.next = map.get(tmp.next);
            copy.random = map.get(tmp.random);
        }
        
        return map.get(head);
    }
}
