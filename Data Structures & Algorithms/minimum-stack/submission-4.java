class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {    
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(minStack.isEmpty() || val <= minStack.peekLast()){
            minStack.addLast(val);
        }
    }
    
    public void pop() {
        if(minStack.peekLast().equals(stack.peekLast())){
            minStack.pollLast();
        }
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}
