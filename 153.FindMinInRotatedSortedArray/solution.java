public class FindMin {
	public static int findMin(int[] nums) {
		if (nums == null) { return Integer.MIN_VALUE; }

		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
		  // if the first member is less than the last member, 
		  // there's no rotation in the array. 
		  if (nums[lo] < nums[hi]) {
		    return nums[lo];
		  }
			int mid = lo + (hi - lo) / 2;
			if (nums[lo] <= nums[mid]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return nums[lo];
	}

	public static void main(String[] args) {
		int[] test = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			test[i] = Integer.valueOf(args[i]);
		}
		System.out.println(findMin(test));
	}
}
