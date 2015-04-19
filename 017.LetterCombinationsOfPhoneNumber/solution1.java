public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits == null || digits.equals("")) return result;
        
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String str = result.remove();
                for (int j = 0; j < map[x].length(); j++) {
                    result.add(str + map[x].charAt(j));
                }
            }
        }
        return result;
    }
}
