public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) { return nums; }
        int[] max = new int[nums.length - k + 1];
        
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        
        // add first k elements into queue
        for (int j = 0; j < k; j++) { pq.offer(nums[j]); }
        int i = 0;
        max[i] = pq.peek();
        
        while (i < max.length - 1) {
            pq.remove(nums[i++]);
            pq.offer(nums[i + k - 1]);
            max[i] = pq.peek();
        } 
        return max;
    }
}
