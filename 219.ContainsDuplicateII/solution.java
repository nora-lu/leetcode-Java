public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) { return false; }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n) && i - map.get(n) <= k) {
                return true;
            } else {
                map.put(n, i);
            }
        }
        return false;
    }
}
