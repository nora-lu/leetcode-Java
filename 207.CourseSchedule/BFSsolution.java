public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) { return true; }
        
        int len = prerequisites.length;
        int[] numPrereq = new int[numCourses];  // record number of prereq for each course
        for (int i = 0; i < len; i++) {
            numPrereq[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int numNoPre = 0;
        for (int i = 0; i < numCourses; i++) {
            if (numPrereq[i] == 0) {  // add courses with no prereq to queue
                q.offer(i); 
                numNoPre++;
            }   
        }
        
        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i = 0; i < len; i++) {  // find another course which needs "course" as prereq
                if (prerequisites[i][1] == course) {
                    numPrereq[prerequisites[i][0]]--;
                    if (numPrereq[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }
}
