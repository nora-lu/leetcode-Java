public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        if (nums == null) { return summary; }
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) { j++; }
            if (i == j) { summary.add("" + nums[i]); }
            else { summary.add(nums[i] + "->" + nums[j]); }
            i = j + 1;
        }
        return summary;
    }
}
