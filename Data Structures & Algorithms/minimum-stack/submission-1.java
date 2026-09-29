class MinStack {
    Stack<Integer> stack;
    Stack <Integer> minstack;

    public MinStack() {
        this.stack =new Stack<>();
        this.minstack =new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(minstack.isEmpty() || val <= minstack.peek()){
            this.minstack.push(val);
        }
    }
    
    public void pop() {
        
        if(minstack.peek().equals(stack.peek())){
            this.minstack.pop();
        }
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minstack.peek();
    }
}
