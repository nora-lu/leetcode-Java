public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(root, ret, new ArrayList<TreeNode>());
        return ret;
    }
    
    private void dfs(TreeNode node, List<String> ret, List<TreeNode> path) {
        if (node == null) { return; }
        path.add(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i).val).append((i < path.size() - 1 ? "->" : ""));
            }
            ret.add(sb.toString());
        }
        if (node.left != null) { dfs(node.left, ret, path); }
        if (node.right != null) { dfs(node.right, ret, path); }
        path.remove(path.size() - 1);
    }
}
