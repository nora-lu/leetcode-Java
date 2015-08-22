public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            Integer lastPos1 = map1.put(c1, i);
            Integer lastPos2 = map2.put(c2, i);
            // if both lastPos1, lastPos2 are null, continue;
            // if one of them is null, return false;
            // if their values are not equal, return false;
            if (lastPos1 != null || lastPos2 != null) {
                if (lastPos1 == null || lastPos2 == null || lastPos1.compareTo(lastPos2) != 0) {
                    return false;
                }
            } 
        }
        return true;
    }
}
