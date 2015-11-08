public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) { return null; }
        // old node->new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            UndirectedGraphNode nCopy = map.get(n);
            for (UndirectedGraphNode cur : n.neighbors) {
                if (!map.containsKey(cur)) {
                    map.put(cur, new UndirectedGraphNode(cur.label));
                    /* Only put cur into queue when map does not contain it!!! */
                    q.offer(cur);
                }
                nCopy.neighbors.add(map.get(cur));
            }
        }
        
        return copy;
    }
}
