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
        int l = 1, r;
        while (l < path.length() && l > 0) {
            r = path.indexOf("/", l);
            String dir = r == -1 ? path.substring(l) : path.substring(l, r);
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
            l = r + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> iter = stack.descendingIterator(); iter.hasNext(); ) {
            sb.append("/").append(iter.next());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
