public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) { return null; }
        StringBuilder sb = new StringBuilder();
        int size = strs.size();
        sb.append(String.valueOf(size));
        if (size > 0) {
            sb.append(",");
            for (int i = 0; i < size; i++) {
                sb.append(strs.get(i).length());
                sb.append(",");
                sb.append(strs.get(i));
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) { return null; }
        List<String> decoded = new ArrayList<String>();
        
        int i = 0, len = s.length();
        // read size of list
        while (i < len && Character.isDigit(s.charAt(i))) { i++; }
        int size = Integer.parseInt(s.substring(0, i));
        if (size == 0) { return decoded; }
        i++;
        for (int k = 0; k < size; k++) {
            int j = i;
            while (j < len && Character.isDigit(s.charAt(j))) { j++; }
            int length = Integer.parseInt(s.substring(i, j));
            decoded.add(s.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return decoded;
    }
}
