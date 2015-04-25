public class Solution {
    public int numTrees(int n) {
        int[] cache = new int[n+1];
        cache[0] = cache[1] = 1;
        
        for (int i=2; i<=n; i++) {
            for (int j=0; j<i; j++) {
                cache[i] += cache[j] * cache[i-j-1];
            }
        }
        return cache[n];
    }
}
