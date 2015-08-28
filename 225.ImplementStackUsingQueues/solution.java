class MyStack {
    Queue<Integer> left = new LinkedList<>();
    Queue<Integer> right = new LinkedList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        right.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        right.poll();
        Queue<Integer> temp = left;
        left = right;
        right = temp;
    }

    // Get the top element.
    public int top() {
        while (right.size() > 1) {
            left.offer(right.poll());
        }
        return right.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return left.size() == 0 && right.size() == 0;
    }
}
