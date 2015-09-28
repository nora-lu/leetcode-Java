public class Vector2D {
    private List<Integer> vec1d;
    private int cursor = -1;
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d != null) {
            vec1d = new ArrayList<>();
            for (List<Integer> list : vec2d) { vec1d.addAll(list); }
        }
    }

    public int next() {
        return vec1d.get(++cursor);
    }

    public boolean hasNext() {
        return cursor + 1 < vec1d.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
