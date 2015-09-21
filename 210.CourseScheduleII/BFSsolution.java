public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) { order[i] = i; }
            return order;
        }
        
        int len = prerequisites.length;
        int[] numPre = new int[numCourses];
        for (int i = 0; i < len; i++) {
            numPre[prerequisites[i][0]]++;
        }
        
        Queue<Integer> noPre = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPre[i] == 0) {
                noPre.offer(i);
            }
        }
        int orderIdx = 0;
        while (!noPre.isEmpty()) {
            int course = noPre.poll();
            order[orderIdx++] = course;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == course) {
                    numPre[prerequisites[i][0]]--;
                    if (numPre[prerequisites[i][0]] == 0) {
                        noPre.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        if (orderIdx != numCourses) {  // impossible to finish
            return new int[]{};
        }
        return order;
    }
}
