public class Solution {
    public String reverseWords(String s) {
        String[] a = s.trim().split(" +");
        String result = "";
        for (int i = a.length - 1; i >= 0; i--) {
            if (i > 0) {
                result = result + a[i] + " ";
            }
            else {
                result += a[i];
            }
        }
        return result;
    }
}
