public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) { return b; }
        if (b == null || b.isEmpty()) { return a; }
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = 0, j = 0;
        
        // remove leading zeros
        while (i < a.length() - 1 && a.charAt(i) == '0') { i++; }
        a = a.substring(i);
        while (j < b.length() - 1 && b.charAt(j) == '0') { j++; }
        b = b.substring(j);
        
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int digitA = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int digitB = (j >= 0) ? (b.charAt(j) - '0') : 0;
            sb.append(digitA ^ digitB ^ carry);
            carry = (digitA + digitB + carry) >= 2 ? 1 : 0;
        }
        return sb.reverse().toString();
    }
}
