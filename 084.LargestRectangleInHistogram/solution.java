public class Solution {
    public int largestRectangleArea(int[] height) {
    // int len = height.length;
    //     Stack<Integer> s = new Stack<Integer>();
    //     int maxArea = 0;
    //     for(int i = 0; i <= len; i++){
    //         int h = (i == len ? 0 : height[i]);
    //         if(s.isEmpty() || h >= height[s.peek()]){
    //             s.push(i);
    //         }else{
    //             int tp = s.pop();
    //             maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
    //             i--;
    //         }
    //     }
    //     return maxArea;
    
    
    // Stack<Integer> stack = new Stack<Integer>();
    //      int i = 0;
    //       int maxArea = 0;
    //       int[] h = new int[height.length + 1];
    //       h = Arrays.copyOf(height, height.length + 1);
    //       while(i < h.length){
    //           if(stack.isEmpty() || h[stack.peek()] <= h[i]){
    //               stack.push(i++);
    //          }else {
    //              int t = stack.pop();
    //              maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
    //          }
    //      }
    //      return maxArea;
    }
     
}
