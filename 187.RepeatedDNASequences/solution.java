public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null) { return null; }
        List<String> res = new ArrayList<>();
        Set<Integer> seq = new HashSet<>();
        Set<Integer> secondTime = new HashSet<>();
        char[] map = new char[26];
        // char['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        for (int i = 0; i < s.length() - 9; i++) {
            int val = 0;
            for (int j = i; j < i + 10; j++) {
                val <<= 2;
                val |= map[s.charAt(j) - 'A'];
            }
            if (!seq.add(val) && secondTime.add(val)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
