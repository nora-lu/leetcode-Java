public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) { return res; }
        backtrack(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == k) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i <= n; i++) {
            sub.add(i);
            backtrack(n, k, i + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }

}
