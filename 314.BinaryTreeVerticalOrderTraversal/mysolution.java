/** Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]  */

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) { return ret; }
        
        Map<Integer, List<Integer>> map = new TreeMap<>();  // key:level, value:list
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        q.offer(root);
        levels.offer(0);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int level = levels.poll();
            List<Integer> list = map.get(level);
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<Integer>());
            }
            map.get(level).add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                levels.offer(level - 1);
            }
            if (node.right != null) {
                q.offer(node.right);
                levels.offer(level + 1);
            }
        }
        
        for (int level : map.keySet()) {  // The set's iterator returns the keys in ascending order.
            ret.add(map.get(level));
        }
        return ret;
    }
}
