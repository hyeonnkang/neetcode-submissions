class MinStack {
    Deque<Integer> deque;
    Deque<Integer> minStack;

    public MinStack() {
        deque = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()) minStack.addLast(val);
        else minStack.addLast(Math.min(minStack.peekLast(), val));

        deque.addLast(val);
    }
    
    public void pop() {
        deque.pollLast();
        minStack.pollLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}
