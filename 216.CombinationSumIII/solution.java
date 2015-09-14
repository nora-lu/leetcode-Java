public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1);
        return res;
    }
    
    private void helper(int k, int sum, int start) {
        if (sum == 0 && k == 0) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i <= 9; i++) {
                int newSum = sum - i;
                if (newSum >= 0) {
                    list.add(i);
                    helper(k - 1, newSum, i + 1);
                    list.remove(list.size() - 1);
                } else { break; }
            }
        }
    }
}
