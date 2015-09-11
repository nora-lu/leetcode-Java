public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) { return b; }
        if (b == null || b.isEmpty()) { return a; }
        
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int aByte = 0, bByte = 0, carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            aByte = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bByte = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            int result = aByte ^ bByte ^ carry;
            carry = aByte + bByte + carry >= 2 ? 1 : 0;
            sb.append(result);
        }
        return sb.reverse().toString();
    }
}
