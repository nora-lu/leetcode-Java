/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if (node == null) { return null; }
        
    //     UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
    //     map.put(copyNode.label, copyNode);
        
    //     List<UndirectedGraphNode> copyNeighbors = copyNode.neighbors; 
    //     for (UndirectedGraphNode neighbor : node.neighbors) {
    //         if (map.containsKey(neighbor.label)) {
    //           copyNeighbors.add(map.get(neighbor.label));         
    //         } else {
    //           UndirectedGraphNode copyNeighbor = cloneGraph(neighbor);
    //           copyNeighbors.add(copyNeighbor);
    //           map.put(copyNeighbor.label, copyNeighbor);
    //         }
    //     }
    //     return copyNode;
    // }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) { return null; }
        // old node->new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        dfs(node, map);
        return copy;
    }
    
    private void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        for (UndirectedGraphNode cur : node.neighbors) {  // for each neighbor of old node
            if (!map.containsKey(cur)) {  
                UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
                map.put(cur, copy);  
                dfs(cur, map);  // clone current neighbor
            }
            map.get(node).neighbors.add(map.get(cur));  // add copied neighbor to copied node
        }
    }
}
