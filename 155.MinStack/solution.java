class MinStack {
    private static class itemWithMin {
        int val;
        int min;
        itemWithMin(int v, int m) {
            val = v;
            min = m;
        }
    }
    
    private ArrayList<itemWithMin> a = new ArrayList<>();
    
    public void push(int x) {
        // check if empty
        if (a.size() == 0 || x <= getMin()) a.add(new itemWithMin(x, x));
        else a.add(new itemWithMin(x, getMin()));
    }

    public void pop() {
        if (a.size() != 0) a.remove(a.size() - 1);
    }

    public int top() {
        if (a.size() != 0) return a.get(a.size() - 1).val;
        return 0;
    }

    public int getMin() {
        if (a.size() != 0) return a.get(a.size() - 1).min;
        return 0;
    }
}
