package Design;

import java.util.*;

class MyStack {
    // Push element x onto stack.
    Queue <Integer> queue = new LinkedList<>();
   // List<Integer> r = new LinkedList<>();
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while(!queue.isEmpty()){
            temp.offer(queue.poll());
        }
        queue.offer(x);
        while(!temp.isEmpty()){
            queue.offer(temp.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}