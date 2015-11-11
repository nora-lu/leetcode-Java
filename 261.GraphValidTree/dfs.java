/** Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges. */

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // adj list
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        // add edges
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        // detect cycle
        if (hasCycle(list, 0, visited, -1)) { return false; }
        
        // make sure connected
        for (boolean b : visited) {
            if (!b) { return false; }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u] = true; 
        for (int v : adj.get(u)) {
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adj, v, visited, u))) { return true; }
        }
        return false;
    }
}
