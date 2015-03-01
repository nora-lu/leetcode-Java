public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int i = digits.length - 1;
        while (i >= 0 && digits[i] + 1 == 10) {
            digits[i] = 0;
            i--;
        }
        if (i == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            // for (int j = 1; j < res.length; j++) res[j] = 0;
            return res;
        }
        digits[i] = digits[i] + 1;
        return digits;
    }
}
