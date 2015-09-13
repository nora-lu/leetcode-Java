public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null) { return null; }
        return recurse(s, 4);
    }
    
    private List<String> recurse(String s, int maxBytes) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len > 3 * maxBytes || len < maxBytes) { return res; }
        if (maxBytes == 1 && isValid(s)) {
            res.add(s);
        } else if (maxBytes > 1) {
            for (int i = 0; i < len && i < 3; i++) {
                String sub = s.substring(0, i + 1);
                if (isValid(sub)) {
                    List<String> sublist = recurse(s.substring(i + 1), maxBytes - 1);
                    if (sublist.size() > 0) {
                        for (String str : sublist) {
                            String newstr = sub + "." + str;
                            res.add(newstr);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        if (s.equals("0")) { return true; }
        else if (s.startsWith("0")) { return false; }
        else {
            int val = Integer.parseInt(s);
            return val > 0 && val < 256;
        }
    }
}
