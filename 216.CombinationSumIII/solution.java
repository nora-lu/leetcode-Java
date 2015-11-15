public class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(int k, int sum, int start, List<List<Integer>> res, List<Integer> list) {
        if (sum == 0 && list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (sum - i >= 0) {
                list.add(i);
                helper(k, sum - i, i + 1, res, list);
                list.remove(list.size() - 1);
            } else { break; }
        }
}
