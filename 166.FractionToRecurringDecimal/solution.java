public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // if denominator = 0?
        if (denominator == 0) { return "Error: denominator is 0."; }
        // if numerator = 0?
        if (numerator == 0) { return "0"; }
        
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        // deal with signs
        int flag = 1;
        if (numerator < 0) {
            flag *= -1;
        }
        if (denominator < 0) {
            flag *= -1;
        }
        if (flag == -1) { sb.append("-"); }
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append(num / den);
        num %= den;
        if (num != 0) {
            sb.append(".");
            map.put(num, sb.length());
            while (num != 0) {
                num *= 10;
                sb.append(num / den);
                num = num  % den;
                if (!map.containsKey(num)) {
                    map.put(num, sb.length());
                } else {
                    int start = map.get(num);
                    sb.insert(start, "(");
                    sb.append(")");
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}
