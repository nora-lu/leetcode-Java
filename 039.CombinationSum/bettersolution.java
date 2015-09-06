public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recurse(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void recurse(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(list);
            return;
        } 
        for (int i = start; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                recurse(res, copy, candidates, newTarget, i);
            } else { break; }
        }
    }
}
