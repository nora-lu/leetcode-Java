public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> groups = new ArrayList<>();
    if (strings == null) { return groups; }

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      char[] chs = str.toCharArray();
      int offset = chs[0] - 'a';
      for (int i = 0; i < chs.length; i++) {
        char c = (char)(chs[i] - offset);
        chs[i] = c < 'a' ? (char)(c + 26) : c;
      }
      String key = new String(chs);
      List<String> list = map.get(key);
      if (list == null) {
        list = new ArrayList<String>();
        map.put(key, list);
      }
      list.add(str);
    }
    for (String key : map.keySet()) {
      List<String> list = map.get(key);
      Collections.sort(list);
      groups.add(list);
    }
    return groups;
  }
}
