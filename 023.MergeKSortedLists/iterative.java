public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }
        int len = lists.length;
        int left = 0, right = len - 1;
        for (int i = 0; i < (len + 1) / 2; i++) {
            while (left < right) {
                lists[left] = mergeTwoLists(lists[left], lists[right]);
                left++; right--;
            }
            left = 0;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
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
        if (l1 != null) { cur.next = l1; }
        if (l2 != null) { cur.next = l2; }
        return dummy.next;
    }
}
