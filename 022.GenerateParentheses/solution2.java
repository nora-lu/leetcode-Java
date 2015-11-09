/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"  */

public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<String>(Arrays.asList("")));  // n = 0
        
        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String first : dp.get(j)) {
                    for (String second : dp.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            dp.add(list);
        }
        return dp.get(n);
    }
