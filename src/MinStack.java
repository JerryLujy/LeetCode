import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>155. Min Stack</h1>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * <p>
 * pop() -- Removes the element on top of the stack.
 * <p>
 * top() -- Get the top element.
 * <p>
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    Deque<Integer> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);// Save the previous min value
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();// Restore previous min value
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
