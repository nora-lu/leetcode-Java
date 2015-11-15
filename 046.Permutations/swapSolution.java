public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permute(res, nums, 0);
        return res;
    }
    
    private void permute(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) { // last element has been fixed so this permutation is simply nums
            List<Integer> list = new ArrayList<Integer>();
            for (int a : nums) { list.add(a); }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {  // start is position where the element is fixed
                swap(nums, i, start); 
                permute(res, nums, start + 1);
                swap(nums, i, start);
            }
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
