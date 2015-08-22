public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) { return null; }
        Map<String, List<String>> m = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (String s : strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String sorted = new String(ar);
            List<String> list = new ArrayList<String>();
            if (m.containsKey(sorted)) {
                list = m.get(sorted);
            }
            list.add(s);
            m.put(sorted, list);
        }
        for (List<String> l : m.values()) {
            Collections.sort(l);
            result.add(l);
        }
        return result;
    }
}
