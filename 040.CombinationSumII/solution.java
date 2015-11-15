public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) { return ret; }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) { continue; }
            if (candidates[i] <= target) {
                comb.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, comb, ret);
                comb.remove(comb.size() - 1);
            } else { break; }
        }
    }
}
