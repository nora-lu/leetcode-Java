public class Solution {
    public int lengthOfLastWord(String s) {
        // s = s.trim();
        
        // int res = 0;
        // for (int i = s.length() - 1; i >= 0; i--) {
        //     if (s.charAt(i) != ' ') res++;
        //     else break;
        // }
        // return res;
        
        int res = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        
        for ( ; i >= 0; i--) {
            if (s.charAt(i) != ' ') res++;
            else return res;
        }
        return res;
    }
}
