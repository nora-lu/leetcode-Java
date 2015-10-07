public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> s1 = new Stack<>();  // predecessors smaller than target
        Stack<Integer> s2 = new Stack<>();  // successors larger than target, traversal in reversed order
        inorder(root, false, target, s1);
        inorder(root, true, target, s2);
        
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            if (s1.isEmpty()) { res.add(s2.pop()); }
            else if (s2.isEmpty()) { res.add(s1.pop()); }
            else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) { res.add(s1.pop()); }
            else { res.add(s2.pop()); }
        }
        return res;
    }
    
    private void inorder(TreeNode node, boolean reverse, double target, Stack<Integer> stack) {
        if (node == null) { return; }
        inorder(reverse ? node.right : node.left, reverse, target, stack);
        if (!reverse && node.val > target || reverse && node.val <= target) { return; }
        stack.push(node.val);
        inorder(reverse ? node.left : node.right, reverse, target, stack);
    }
}
