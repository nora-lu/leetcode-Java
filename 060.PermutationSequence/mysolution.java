public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        while (sb.length() < n) {
            int ft = factorial(candidates.size() - 1);
            int idx = (k - 1) / ft;
            sb.append(candidates.get(idx));
            candidates.remove(idx);
            k = k - ft * idx;
        }
        return sb.toString();
    }
    
    private int factorial(int n) {
        if (n <= 0) { return 1; }
        int res = 1;
        for (int i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }
}
