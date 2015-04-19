public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[] {
            "0",
            "1",
            "abc", 
            "def", 
            "ghi", 
            "jkl", 
            "mno", 
            "pqrs", 
            "tuv", 
            "wxyz"
        };
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            List<String> tmp = new LinkedList<>();
            for (Character c : map[x].toCharArray()) {
                for (String str : res) {
                    tmp.add(str + c);
                }
            }
            res = tmp;
        }
        return res;
    }
}
