/* Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? */

public class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        traversal(root, inorder);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val < inorder.get(i + 1).val) { continue; }
            int j = i;
            while (j < inorder.size() - 1 && inorder.get(j + 1).val < inorder.get(i).val) { j++; }
            int tmp = inorder.get(i).val;
            inorder.get(i).val = inorder.get(j).val;
            inorder.get(j).val = tmp;
            break;
        }
    }
    
    private void traversal(TreeNode node, List<TreeNode> list) {
        if (node == null) { return; }
        traversal(node.left, list);
        list.add(node);
        traversal(node.right, list);
    }
}
