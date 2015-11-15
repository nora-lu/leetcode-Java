public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] ret = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                ret[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = m + n - 1; i >= 0; i--) {
            int sum = carry + ret[i];
            ret[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < m + n - 1 && ret[i] == 0) { i++; }
        while (i < m + n) { sb.append(ret[i++]); }
        return sb.toString();
    }
}
