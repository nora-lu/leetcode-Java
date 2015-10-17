public class ValidWordAbbr {
  Map<String, Set<String>> map = new HashMap<>();
  public ValidWordAbbr(String[] dictionary) {
    for (String str : dictionary) {
      String abbr = getAbbr(str);
      Set<String> set = map.get(abbr);
      if (set == null) { set = new HashSet<String>(); }
      set.add(str);
      map.put(abbr, set);
    }
  }

  public boolean isUnique(String word) {
    Set<String> set = map.get(getAbbr(word));
    return set == null || (set.contains(word) && set.size() == 1);
  }

  private String getAbbr(String word) {
    if (word == null || word.length() <= 2) { return word; }
    int n = word.length();
    return word.charAt(0) + Integer.toString(n - 2) + word.charAt(n - 1);
  }
}
