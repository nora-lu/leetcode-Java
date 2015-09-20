public class Solution {
    private boolean[] visited;  // default to false
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) { return true; }
        
        visited = new boolean[numCourses];
        
        // save graph
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) { graph[i] = new ArrayList(); }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);  // prereq points to the course to take
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i)) { return false; }
        }
        return true;
    }
    
    private boolean dfs(ArrayList[] graph, int course) {
        if (visited[course]) { return false; }
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, (int)graph[course].get(i))) { return false; }
        }
        visited[course] = false;
        return true;
    }
}
