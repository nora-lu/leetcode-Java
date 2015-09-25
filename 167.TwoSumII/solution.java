public class TwoSumII {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null) { return null; }
    int[] res = new int[2];
    int lo = 0, hi = numbers.length - 1;
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi];
      if (sum == target) {
        res[0] = lo + 1;
        res[1] = hi + 1;
        return res;
      } else if (sum < target) {
        // not necessary to check duplicates if assuming exactly one solution (meaning no duplicates)
        while (lo < hi && numbers[lo] == numbers[lo + 1]) { lo++; }
        lo++;
      } else {
        while (lo < hi && numbers[hi] == numbers[hi - 1]) { hi--; }
        hi--;
      }
    }
    return res;
  }
}
