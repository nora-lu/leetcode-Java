public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null) { return res; }
        res.add(new ArrayList<Integer>());
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(res.get(j));
                newSubset.add(nums[i]);
                res.add(newSubset);
            }
        }
        
        return res;
    }
}
