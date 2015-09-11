public class Solution {
    public String multiply(String num1, String num2) {
          if (num1 == null || num2 == null) { return null; }
          int len1 = num1.length(), len2 = num2.length();
          int[] tmp = new int[len1 + len2];
          int k = len1 + len2 - 2;
          for (int i = len1 - 1; i >= 0; i--) {
              for (int j = len2 - 1; j >= 0; j--) {
                  int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                  tmp[k - i - j] += product;
              }
          }
          int carry = 0;
          for (int i = 0; i <= k + 1; i++) {
              int withcarry = tmp[i] + carry;
              tmp[i] = withcarry % 10;
              carry = withcarry / 10;
          }
          String s = "";
          int idx = k + 1;
          while (idx >= 0 && tmp[idx] == 0) { idx--; }
          if (idx < 0) { s += "0"; }
          else {
              for ( ; idx >= 0; idx--) { s += tmp[idx]; }
          }
          return s;
    }
}
