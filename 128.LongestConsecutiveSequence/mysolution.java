/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. */

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) { return 0; }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) { set.add(i); }
        
        int max = 0;
        for (int i : nums) {
            int count = 0;
            // check if i is first element of sequence
            if (!set.contains(i - 1)) {
                int j = i;
                while (set.contains(j++)) { count++; } 
            } 
            max = Math.max(max, count);
        }
        
        return max;
    }
}
