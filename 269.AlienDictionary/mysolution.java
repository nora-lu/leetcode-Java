public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) { return ""; }
        if (words.length == 1) { return words[0]; }
        Map<Character, Set<Character>> g = new HashMap<Character, Set<Character>>();
        buildGraph(words, g);
        for (char c : g.keySet()) {
            System.out.print(c + ": ");
            for (char v : g.get(c)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        return topoSort(g);
    }

    private String topoSort(Map<Character, Set<Character>> graph) {
        boolean[] visited = new boolean[26];
        boolean[] tmp = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (char c : graph.keySet()) {
            if (!dfs(graph, visited, tmp, sb, c)) { return ""; }
        }
        sb.reverse();
        return sb.toString();
    }

    private boolean dfs(Map<Character, Set<Character>> graph, boolean[] visited, boolean[] tmp, StringBuilder sb, char u) {
        if (tmp[u - 'a']) { return false; }
        if (!visited[u - 'a']) {
            tmp[u - 'a'] = true;
            for (char v : graph.get(u)) {
                if (!dfs(graph, visited, tmp, sb, v)) { return false; }
            }
            tmp[u - 'a'] = false;
            visited[u - 'a'] = true;
            sb.append(u);
        }
        // System.out.println(sb.toString());
        return true;
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph) {
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len1 = w1.length();
            int len2 = w2.length();
            boolean found = false;
            for (int j = 0; j < Math.max(len1, len2); j++) {
                char c1 = j < len1 ? w1.charAt(j) : ' ';
                char c2 = j < len2 ? w2.charAt(j) : ' ';
                if (c1 != ' ' && c2 != ' ' && c1 != c2 && !found) {
                    Set<Character> set = graph.get(c1);
                    if (set == null) { set = new HashSet<>(); }
                    set.add(c2);
                    graph.put(c1, set);
                    found = true;
                }
                if (c1 != ' ' && !graph.containsKey(c1)) { graph.put(c1, new HashSet<Character>()); }
                if (c2 != ' ' && !graph.containsKey(c2)) { graph.put(c2, new HashSet<Character>()); }
            }
        }
    }
}
