public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) { return null; }
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<Integer>(), res);
    return res;
  }
  
  private void backtrack(int[] nums, int start, List<Integer> sub, List<List<Integer>> res) {
    res.add(new ArrayList<Integer>(sub));
    for (int i = start; i < nums.length; i++) {
      sub.add(nums[i]);
      backtrack(nums, i + 1, sub, res);
      sub.remove(sub.size() - 1);
    }
  } 

}
