public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> int_rome = new HashMap<>();
        int_rome.put(1000, "M");
        int_rome.put(900, "CM");
        int_rome.put(500, "D");
        int_rome.put(400, "CD");
        int_rome.put(100, "C");
        int_rome.put(90, "XC");
        int_rome.put(50, "L");
        int_rome.put(40, "XL");
        int_rome.put(10, "X");
        int_rome.put(9, "IX");
        int_rome.put(5, "V");
        int_rome.put(4, "IV");
        int_rome.put(1, "I");
        
        String res = "";
        int i = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit != 0) {
                int ten_pow = (int)Math.pow(10, i);
                int value = digit * ten_pow;
                while (!int_rome.containsKey(value)) {
                    res = int_rome.get(ten_pow) + res;
                    value -= ten_pow;
                }
                res = int_rome.get(value) + res;
            }
            num = num / 10;
            i++;
        }
        return res;
    }
}
