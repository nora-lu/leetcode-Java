public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return compute(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> compute(String input, Map<String, List<Integer>> cache) {
        if (cache.get(input) != null) { return cache.get(input); }
        
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = compute(input.substring(0, i), cache);
                List<Integer> right = compute(input.substring(i + 1), cache);
                for (int x : left) {
                    for (int y : right) {
                        switch (c) {
                            case '+':
                                ret.add(x + y);
                                break;
                            case '-':
                                ret.add(x - y);
                                break;
                            case '*':
                                ret.add(x * y);
                                break;
                        }
                            
                    }
                }
            }
        }
        if (ret.size() == 0) { ret.add(Integer.parseInt(input)); }  // when input does not have operators!
        cache.put(input, ret);
        return ret;
    }
}
