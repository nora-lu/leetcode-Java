public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    if (nums == null) { return null; }
    int candidate1 = 0, candidate2 = 1;
    int ctr1 = 0, ctr2 = 0;
    List<Integer> res = new ArrayList<>();
    for (int i : nums) {
      if (i == candidate1) {
        ctr1++;
      } else if (i == candidate2) {
        ctr2++;
      } else if (ctr1 == 0) {
        candidate1 = i;
        ctr1 = 1;
      } else if (ctr2 == 0) {
        candidate2 = i;
        ctr2 = 1;
      } else {
        ctr1--; 
        ctr2--;
      }
    }
    ctr1 = 0;
    ctr2 = 0;
    for (int i : nums) {
      if (i == candidate1) { ctr1++; }
      else if (i == candidate2) { ctr2++; }
    }
    if (ctr1 > nums.length / 3) { res.add(candidate1); }
    if (ctr2 > nums.length / 3) { res.add(candidate2); }
    return res;
  }
}
