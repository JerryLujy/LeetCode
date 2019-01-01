import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * <h1>71. Simplify Path</h1>
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * <p>
 * path = "/home/", => "/home"
 * <p>
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * path = "/../", In this case, you should return "/".
 * <p>
 * Path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 * @author Jerry
 * @since 8/30/16
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : (path + "/").toCharArray()) {
            if (c == '/') {
                String token = sb.toString();
                if ("..".equals(token) && !stack.isEmpty()) {
                    stack.pop();
                } else if (token.length() > 0 && !".".equals(token) && !"..".equals(token)) {
                    stack.push(token);
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        sb.setLength(0);
        for (Iterator<String> iter = stack.descendingIterator(); iter.hasNext(); ) {
            sb.append("/").append(iter.next());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
