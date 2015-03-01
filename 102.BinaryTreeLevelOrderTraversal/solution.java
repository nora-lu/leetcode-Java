/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class NodeWithLevel {
            TreeNode node;
            int level;
            NodeWithLevel(TreeNode n, int l) {
                node = n;
                level = l;
            }
        }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        Queue<NodeWithLevel> q = new LinkedList<>();
        q.add(new NodeWithLevel(root, 0));
        
        while (!q.isEmpty()) {
            NodeWithLevel toVisit = q.peek();
            TreeNode n = toVisit.node;
            
            if (n.left != null || n.right != null) {
                if (n.left != null) q.add(new NodeWithLevel(n.left, toVisit.level + 1));
                if (n.right != null) q.add(new NodeWithLevel(n.right, toVisit.level + 1)); 
            }
            
            NodeWithLevel visited = q.remove();
            if (list.size() <= visited.level) {
                List<Integer> a = new ArrayList<>();
                a.add(visited.node.val);
                list.add(a);
            }
            else list.get(visited.level).add(visited.node.val);
        }
        return list;
    }
}
