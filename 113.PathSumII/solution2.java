/* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]  */

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) { return ret; }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathSum(root, sum, path, ret);
        return ret;
    }
    
    private void pathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> ret) {
        if (node.left == null && node.right == null && node.val == sum) {
            ret.add(new ArrayList<Integer>(path));
            return;
        } 
        if (node.left != null) {
            path.add(node.left.val);
            pathSum(node.left, sum - node.val, path, ret);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            pathSum(node.right, sum - node.val, path, ret);
            path.remove(path.size() - 1);
        }
    }
}
