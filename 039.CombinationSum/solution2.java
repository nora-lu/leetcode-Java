public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<List<Integer>>> dp = new ArrayList<>();
  Arrays.sort(candidates);
  for (int t = 1; t <= target; t++) {  // run through all targets from 1
    List<List<Integer>> list = new ArrayList<>();  // combs for target t
    for (int i = 0; i < candidates.length && candidates[i] <= t; i++) {
      if (candidates[i] == t) { list.add(Arrays.asList(candidates[i])); }
      // if current candidate is less than the target, use prev results
      else {
        for (List<Integer> l : dp.get(t - candidates[i] - 1)) {
          if (candidates[i] <= l.get(0)) {  // avoid duplicate list
            List<Integer> newList = new ArrayList<>();
            newList.add(candidates[i]);
            newList.addAll(l);
            list.add(newList);
          }
        }
      }
    }
    dp.add(list);
  }
  return dp.get(target - 1);
}
