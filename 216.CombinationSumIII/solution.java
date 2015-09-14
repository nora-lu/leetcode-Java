public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return res;
    }
    
    private void helper(int k, int sum, int start) {
        if (sum == 0 && list.size() == k) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i <= 9; i++) {
               if (sum - i >= 0) {
                   list.add(i);
                   helper(k, sum - i, i + 1);
                   list.remove(list.size() - 1);
               } else { break; }
            }
        }
    }
}
