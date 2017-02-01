import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>225. Implement Stack using Queues</h1>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack.
 * top() -- Get the top element. empty() -- Return whether the stack is empty.
 * <p>
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * @author Jerry
 * @since 1/31/17
 */
public class ImplementStackUsingQueues {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
