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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) { map.put(inorder[i], i); }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1 );
    }
    
    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) { return null; }
        int rootVal = preorder[ps];
        int posIn = is;
        while (inorder[posIn] != rootVal) { posIn++; }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, ps + 1, ps + posIn - is, inorder, is, posIn - 1);
        root.right = buildTree(preorder, ps + posIn - is + 1, pe, inorder, posIn + 1, ie);
        return root;
    }
}
