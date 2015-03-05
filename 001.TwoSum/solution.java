public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        java.util.Hashtable<Integer, Integer> table = new java.util.Hashtable<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (table.containsKey(target - numbers[i])) {
                res[0] = table.get(target - numbers[i]);
                res[1] = i + 1; // not zero-base;
                return res;
            }
            table.put(numbers[i], i + 1); // not zero-based;
        }
        return res;
    }
}
