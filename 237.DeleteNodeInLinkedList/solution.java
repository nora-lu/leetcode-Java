public class Solution {
    public void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
