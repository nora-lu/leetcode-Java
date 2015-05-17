public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) { return null; }
        return permute(nums, nums.length - 1);
    }
    
    private List<List<Integer>> permute(int[] nums, int end) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums.length == 0 || end < 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<List<Integer>> subResult = permute(nums, end - 1);
        for (List<Integer> list : subResult) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newPerm = new ArrayList<Integer>(list);
                newPerm.add(i, nums[end]);
                res.add(newPerm);
            }
        }
        return res;
    }
}
