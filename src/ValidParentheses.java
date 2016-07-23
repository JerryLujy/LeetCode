import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>20. Valid Parentheses</h1>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * @author Jerry
 * @since 7/22/16
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.offerFirst(c);
            } else {
                if (c == ')' && (stack.isEmpty() || stack.peekFirst() != '(')) return false;
                else if (c == ']' && (stack.isEmpty() || stack.peekFirst() != '[')) return false;
                else if (c == '}' && (stack.isEmpty() || stack.peekFirst() != '{')) return false;
                stack.pollFirst();
            }
        }
        return stack.isEmpty();
    }
}
