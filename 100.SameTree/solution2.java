/* Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value. */

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) { return p == null && q == null; }
        Queue<TreeNode> pTree = new LinkedList<>();
        Queue<TreeNode> qTree = new LinkedList<>();
        pTree.offer(p);
        qTree.offer(q);
        
        while (!pTree.isEmpty() && !qTree.isEmpty()) {
            TreeNode pTop = pTree.poll();
            TreeNode qTop = qTree.poll();
            if (pTop.val != qTop.val) { return false; }
            if (pTop.left != null && qTop.left != null) {
                pTree.offer(pTop.left);
                qTree.offer(qTop.left);
            } else if (pTop.left == null && qTop.left == null) {}
            else { return false; }
            
            if (pTop.right != null && qTop.right != null) {
                pTree.offer(pTop.right);
                qTree.offer(qTop.right);
            } else if (pTop.right == null && qTop.right == null) {}
            else { return false; }
        }
        return pTree.size() == qTree.size();
    }
}
