public class Solution {
    private List<List<String>> res;
    private List<String> curlist;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        curlist = new ArrayList<>();
        partition(s, 0);
        return res;
    }
    
    private void partition(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(curlist));
        } 
        for (int i = index; i < s.length(); i++) {
            if (check(s, index, i)) {
                curlist.add(s.substring(index, i + 1));
                partition(s, i + 1);
                /**
                 * Understand this!
                 */
                curlist.remove(curlist.size() - 1);
            }
        }
    }
    
    private boolean check(String s, int start, int end) {
        for (int i = start; i < start + (end - start + 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(start + end - i)) { return false; }
        }
        return true;
    }
}
