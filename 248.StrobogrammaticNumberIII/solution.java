public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> res = new ArrayList<>();
        for (int len = low.length(); len <= high.length(); len++) {
            res.addAll(helper(len, len));
        }
        int count = 0;
        for (String s : res) {
            if ((s.length() == low.length() && s.compareTo(low) < 0) 
                || (s.length() == high.length() && s.compareTo(high) > 0)) {
                    continue;
                }
            count++;
        }
        return count;
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) { return new ArrayList<String>(Arrays.asList("")); }
        if (n == 1) { return new ArrayList<String>(Arrays.asList("0", "1", "8")); }
        List<String> sub = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (String str : sub) {
            if (n != m) { res.add("0" + str + "0"); }
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        return res;
    }
}
