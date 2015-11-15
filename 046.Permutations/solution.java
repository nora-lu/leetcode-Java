public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        if (nums == null || nums.length == 0) { return ret; }
        ret.add(new LinkedList<>());
        for (int n : nums) {
            int size = ret.size();
            for (int i = 0; i < size; i++) {
                List<Integer> prevPerm = ret.remove(0);
                for (int pos = 0; pos <= prevPerm.size(); pos++) {
                    List<Integer> newPerm = new LinkedList<>(prevPerm);
                    newPerm.add(pos, n);
                    ret.add(newPerm);
                }
            }
        }
        return ret;
    }
}
