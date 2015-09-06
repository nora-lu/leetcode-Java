public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
        // Do not forget the empty subset!
        
        subsets.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        
        int size = 0, startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
          // If we want to insert an element which is a dup, we can only insert it
          // after the newly inserted elements from last step.
            startIndex = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = subsets.size();
            for (int j = startIndex; j < size; j++) {
                List<Integer> subset = new ArrayList<Integer>(subsets.get(j));
                subset.add(nums[i]);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
