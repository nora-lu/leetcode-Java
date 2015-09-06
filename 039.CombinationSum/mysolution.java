public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       Arrays.sort(candidates);
       return combinationSum(candidates, target, 0);
    }
    
    private List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == candidates.length || target < candidates[start]) { return res; }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            for (int freq = 1; freq * candidate <= target; freq++) {
                List<List<Integer>> sub = combinationSum(candidates, target - freq * candidate, i + 1);
                if (freq * candidate == target || sub.size() > 0) {
                    List<Integer> newlist = new ArrayList<>();
                    for (int j = 0; j < freq; j++) { newlist.add(candidate); }
                    if (freq * candidate == target) { res.add(newlist); }
                    else {
                        for (List<Integer> list : sub) {
                            List<Integer> copy = new ArrayList<>(newlist);
                            copy.addAll(list);
                            res.add(copy);
                        }
                    }
                }
            }
        }
        return res;
    }
}
