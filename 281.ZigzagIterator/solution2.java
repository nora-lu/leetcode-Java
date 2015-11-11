/* This solution can be extended to k lists */

public class ZigzagIterator {
    Queue<Iterator> list = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) { list.offer(v1.iterator()); }
        if (!v2.isEmpty()) { list.offer(v2.iterator()); }
    }

    public int next() {
        Iterator it = list.poll();
        int next = (Integer)it.next();
        if (it.hasNext()) { list.offer(it); }
        return next;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
