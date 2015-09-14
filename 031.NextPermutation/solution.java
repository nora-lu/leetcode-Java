public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) { return; }
        // Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) { i--; }
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        // k = i - 1
        // Find the largest index l greater than k such that a[k] < a[l]. (!!!Find the rightmost)
        int j = nums.length - 1;
        while (nums[j] <= nums[i - 1]) { j--; }
        // Swap the value of a[k] with that of a[l].
        int tmp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = tmp;
        // Reverse the sequence from a[k + 1] up to and including the final element a[n].
        j = nums.length - 1;
        while (j > i) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }
    }
}
