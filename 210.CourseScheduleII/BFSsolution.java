public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        // special corner case
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) { order[i] = i; }
            return order;
        }
        
        int len = prerequisites.length;
        
        List<List<Integer>> adj = new ArrayList<>(numCourses);  // store the graph
        for (int i = 0; i < numCourses; i++) { adj.add(new ArrayList<>()); }
        
        int[] numPre = new int[numCourses];  // record number of pre for each course
        for (int[] edge : prerequisites) {
            numPre[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);  // 1->2, 1 must be taken before 2.
        }
        
        Queue<Integer> noPre = new LinkedList<>();
        // add courses not need pre to Queue
        for (int i = 0; i < numCourses; i++) {
            if (numPre[i] == 0) {
                noPre.offer(i);
            }
        }
        
        int visited = 0;
        while (!noPre.isEmpty()) {
            int from = noPre.poll();
            order[visited++] = from;
            for (int to : adj.get(from)) {
                numPre[to]--;
                if (numPre[to] == 0) {
                    noPre.offer(to);
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }
}
