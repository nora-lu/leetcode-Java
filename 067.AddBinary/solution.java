public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) { return null; }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = 0, y = 0;
            if (i >= 0 && a.charAt(i) == '1') { x = 1; }
            if (j >= 0 && b.charAt(j) == '1') { y = 1; }
            int sum = x + y + carry;
            if (sum >= 2) {
                sum = sum == 2 ? 0 : 1;
                carry = 1;
            } else { carry = 0; }
            sb.append(sum);
        }
        if (carry == 1) { sb.append('1'); }
        sb.reverse();
        return sb.toString();
    }
}
