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
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (visited[u]) { return false; }
            visited[u] = true;
            for (int v : list.get(u)) {
                q.offer(v);
                /**
                  IMPORTANT!!!
                 */
                list.get(v).remove((Integer)u);
            }
        }
        for (boolean b : visited) {
            if (!b) { return false; }
        }
        return true;
    }
}
