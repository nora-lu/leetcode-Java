public class Solution {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<>();
        // use arraylist to mark anagram groups.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String str : strs) {
            // sort the string
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            
            ArrayList<String> anagrams = map.get(key);
            if (anagrams == null) {
                anagrams = new ArrayList<String>();
                anagrams.add(str);
                map.put(key, anagrams);
            }
            else anagrams.add(str);
        }
        
        for (ArrayList list : map.values()) {
            if (list.size() > 1) res.addAll(list);
        }
        return res;
    }
}
