public class Codec {
    private final String spliter = ",";
    private final String NN = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> q) {
        String str = q.poll();
        if (str.equals(NN)) { return null; }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserialize(q);
        node.right = deserialize(q);
        return node;
    }
}
