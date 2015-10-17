public class ValidWordAbbr {
  Map<String, String> map = new HashMap<>();
  
  public ValidWordAbbr(String[] dictionary) {
    for (String str : dictionary) {
      String abbr = getAbbr(str);
      if (map.containsKey(abbr)) { map.put(abbr, null); }  // not unique
      else { map.put(abbr, str); }
    }
  }
  
  public boolean isUnique(String word) {
    String key = getAbbr(word);
    return !map.containsKey(key) || word.equals(map.get(key));  
    // pay attention to Null exception here if reversing word and map.get(key)
  }

  private String getAbbr(String word) {
    if (word == null) { return word; }
    int n = word.length();
    return word.charAt(0) + n <= 2 ? "" : Integer.toString(n - 2) +
               word.charAt(n - 1);
  }
}
