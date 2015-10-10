public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 1) { return -1; }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) { stack.push(i); }
        
        int a = 0, b = 0;
        while (stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();
            if (knows(a, b)) {
                // a knows b, so a is not the celebrity, but b may be
                stack.push(b);
            } else {
                // a doesn't know b, so b is not the celebrity, but a may be
                stack.push(a);
            }
        }
        
        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }
        return candidate;
    }
}
