import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>227. Basic Calculator II</h1>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples: "3+2*2" = 7, " 3/2 " = 1, " 3+5 / 2 " = 5
 *
 * @author Jerry
 * @since 2/1/17
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int num = 0;
        char prev = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (prev == '+') {
                    stack.push(num);
                } else if (prev == '-') {
                    stack.push(-num);
                } else if (prev == '*') {
                    stack.push(stack.pop() * num);
                } else if (prev == '/') {
                    stack.push(stack.pop() / num);
                }
                prev = c;
                num = 0;
            }
        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}
