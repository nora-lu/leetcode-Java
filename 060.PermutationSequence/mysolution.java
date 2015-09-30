public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> candidates = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        
        while (sb.length() < n) {
            int ft = fact[candidates.size() - 1];
            int idx = (k - 1) / ft;
            sb.append(candidates.get(idx));
            candidates.remove(idx);
            k = k - ft * idx;
        }
        return sb.toString();
    }
}
