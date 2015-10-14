public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 1) { return nums; }
        
        int n = nums.length, maxIdx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] max = new int[n - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // remove indices out of window range
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove indices of elements smaller than new element
            // ensure head of queue is max
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                max[maxIdx++] = nums[q.peek()];
            }
        }
        return max;
    }
}
