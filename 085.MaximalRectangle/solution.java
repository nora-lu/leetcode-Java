public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) { return 0; }
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        int max = 0;
        
        for (int row = 0; row < m; row++) {
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < n + 1; i++) {
                if (i < n) {
                    height[i] = matrix[row][i] == '1' ? height[i] + 1 : 0;
                }
                if (s.isEmpty() || height[s.peek()] <= height[i]) {
                    s.push(i);
                } else {
                    while (!s.isEmpty() && height[i] < height[s.peek()]) {
                        int top = s.pop();
                        max = Math.max(max, height[top] * (s.isEmpty() ? i : i - s.peek() - 1));
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}
