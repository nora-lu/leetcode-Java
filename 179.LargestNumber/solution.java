public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, new Comparator<String>() {
        public int compare(String s1, String s2) {
          String concat1 = s1 + s2;
          String concat2 = s2 + s1;
          return -concat1.compareTo(concat2);} });
    StringBuilder sb = new StringBuilder();
    for (String s : strs) { sb.append(s); }
    
    // Do not deleting leading zeros!!!
    while (sb.charAt(0) == '0' && sb.length() > 1) {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}
