public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) { return ret; }
        Arrays.sort(nums);
        
        boolean hasNext = true;
        while (hasNext) {
            addToRet(ret, nums);
            hasNext = nextPermutation(nums);
        }
        return ret;
    }
    
    private void addToRet(List<List<Integer>> ret, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr) { list.add(n); }
        ret.add(list);
    }
    
    private boolean nextPermutation(int[] nums) {
        // Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) { i--; }
        if (i == 0) { return false; }
        
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
        return true; 
    }
}
