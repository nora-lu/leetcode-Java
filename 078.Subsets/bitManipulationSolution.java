public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) { return null; }
        
        int nums_size = nums.length;
        int subsets_size = 1 << nums_size; // 2 ^ nums_size
        List<List<Integer>> res = new ArrayList<List<Integer>>(subsets_size);
        Arrays.sort(nums);
        
        for (int i = 0; i < subsets_size; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < nums_size; j++) {
                if (((i >> j) & 1) == 1) { subset.add(nums[j]); }
            }
            res.add(subset);
        }
        return res;
    }
}
