public class WordDistance {
  private Map<String, List<Integer>> map = new HashMap<>();

  public WordDistance(String[] words) {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      List<Integer> list = map.get(word);
      if (list == null) {
        list = new ArrayList<Integer>();
      }
      list.add(i);
      map.put(word, list);
    }
  }
 


  public int shortest(String word1, String word2) {
    int min = Integer.MAX_VALUE;
    for (int i : map.get(word1)) {
      for (int j : map.get(word2)) {
        min = Math.min(min, Math.abs(i - j));
      }
    }
    return min;
  }
}
