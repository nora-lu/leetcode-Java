public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(list);
        }
        else {
            int i = start;
            while (i < candidates.length) {
                if (i == start || candidates[i] != candidates[i - 1]) { // Avoid duplicates
                    int newTarget = target - candidates[i];
                    if (newTarget >= 0) {
                        List<Integer> copy = new ArrayList<>(list);
                        copy.add(candidates[i]);
                        helper(candidates, i + 1, newTarget, copy, res);
                    } else { break; }
                }
                i++;
            }
        }
    }
}
