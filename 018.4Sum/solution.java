public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) { return null; }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int lo = j + 1, hi = nums.length - 1, target2 = target - nums[i] - nums[j];
                        while (lo < hi) {
                            int sum = nums[lo] + nums[hi];
                            if (sum == target2) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                            } 
                            if(sum <= target2) {
                                while (lo < hi && nums[lo] == nums[lo + 1]) { lo++; }
                                lo++;
                            }  
                            if (sum >= target2) {
                                while (lo < hi && nums[hi] == nums[hi - 1]) { hi--; }
                                hi--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
