public int majorityElement(int[] nums) {
        int ret = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                ret = n;
                count++;
            } else { count = (n == ret ? count + 1 : count - 1); }
        }
        return ret;
    }
