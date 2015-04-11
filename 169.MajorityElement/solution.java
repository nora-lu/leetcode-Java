public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            int element = num[i];
            if (map.containsKey(element)) map.put(element, map.get(element) + 1);
            else map.put(element, 1);
        }
        int major = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > num.length / 2) {
                major = i;
                break;
            }
        }
        return major;
    }
}
