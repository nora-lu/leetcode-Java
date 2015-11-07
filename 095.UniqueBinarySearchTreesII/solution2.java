/* Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3  */
   
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] ret = new List[n + 1];
        ret[0] = new ArrayList<TreeNode>();  // n=0
        ret[0].add(null);
        
        for (int len = 1; len <= n; len++) {
            ret[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode left : ret[j]) {
                    for (TreeNode right : ret[len - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        ret[len].add(root);
                    }
                }
            }
        }
        return ret[n];
    }
    
    private TreeNode clone(TreeNode root, int offset) {
        if (root == null) { return null; }
        TreeNode newRoot = new TreeNode(root.val + offset);
        newRoot.left = clone(root.left, offset);
        newRoot.right = clone(root.right, offset);
        return newRoot;
    }
}
