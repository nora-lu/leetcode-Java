public static int removeDuplicates2(int[] nums) {
        return removeDuplicates(nums, 2);
    }
    /**
     *  Generalized solution for at most k times.
     */
    private static int removeDuplicates(int[] nums, int k) {
        if (nums == null || nums.length == 0) { return 0; }
        if (k >= nums.length) { return nums.length; }

        int newLen = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 1;
                nums[newLen++] = nums[i];
            } else {
                if (++count <= k) {
                    nums[newLen++] = nums[i];
                }
            }
        }
        return newLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3};
        System.out.println("The array is " + Arrays.toString(nums));
        System.out.println("The new length is " + removeDuplicates2(nums));
    }
