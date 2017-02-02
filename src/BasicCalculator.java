import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>224. Basic Calculator</h1>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples: "1 + 1" = 2, " 2-1 + 2 " = 3, "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * @author Jerry
 * @since 2/1/17
 */
public class BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0, cur = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                result += sign * cur;
                cur = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * cur;
                cur = 0;
                result = result * stack.pop() + stack.pop();
            }
        }
        result += sign * cur;
        return result;
    }
}
