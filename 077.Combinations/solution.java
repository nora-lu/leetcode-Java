public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= k; i++) {
            if (result.size() == 0) {
                for (int j = 1; j <= n; j++) {
                    List<Integer> sublist = new ArrayList<Integer>();
                    sublist.add(j);
                    result.add(sublist);
                }
            } else {
                int size = result.size();
                for (int h = 0; h < size; h++) {
                    List<Integer> sublist = result.remove(0);
                    int last = sublist.get(i - 2);
                    for (int m = last + 1; m <= n; m++) {
                        List<Integer> newlist = new ArrayList<Integer>();
                        newlist.addAll(sublist);
                        newlist.add(m);
                        result.add(newlist);
                    }
                }
            }
        }
        return result;
    }
}
