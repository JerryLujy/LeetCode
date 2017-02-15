import java.util.*;

/**
 * <h1>301. Remove Invalid Parentheses</h1>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * <p>
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * <p>
 * ")(" -> [""]
 *
 * @author Jerry
 * @since 2/14/17
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (isValid(curr)) {
                res.add(curr);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < curr.length(); i++) {
                if (!Character.isLetter(curr.charAt(i))) {
                    String newS = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(newS)) {
                        visited.add(newS);
                        queue.offer(newS);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')' && --cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
}
