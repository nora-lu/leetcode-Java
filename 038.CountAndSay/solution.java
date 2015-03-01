public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "";
        String prev = countAndSay(n - 1);
        int i = 0, count = 1;
        while (i < prev.length() - 1) {
            if (prev.charAt(i) == prev.charAt(i + 1)) count++;
            else {
                res = res + count + prev.charAt(i);
                count = 1;
            }
            i++;
        }
        res = res + count + prev.charAt(i);
        return res.toString();
    }
}
