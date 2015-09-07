/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int psStart, int psEnd) {
        if (inStart > inEnd || psStart > psEnd) { return null; }
        int rootVal = postorder[psEnd];
        int rootPos = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inStart, rootPos - 1, postorder, psStart, psStart + rootPos - inStart - 1);
        root.right = buildTree(inorder, rootPos + 1, inEnd, postorder, psStart + rootPos - inStart, psEnd - 1);
        return root;
    }
}
