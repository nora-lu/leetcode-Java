public class Solution {
    private static Map<String, List<Integer>> cache = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (cache.get(input) != null) { return cache.get(input); }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> ltlist = diffWaysToCompute(left);
                List<Integer> rtlist = diffWaysToCompute(right);
                for (Integer lt : ltlist) {
                    for (Integer rt : rtlist) {
                        int n = 0;
                        switch (c) {
                            case '+': n = lt + rt;
                                break;
                            case '-': n = lt - rt;
                                break;
                            case '*': n = lt * rt;
                                break;
                        }
                        res.add(n);
                    }
                }
            }
        }
        if (res.size() == 0) {  // Don't forget!!! Input is just number, no operators.
            res.add(Integer.valueOf(input));
        }
        cache.put(input, res);
        return res;
    }
}
