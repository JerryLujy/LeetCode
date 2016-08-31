import java.util.Deque;
import java.util.LinkedList;

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
        Deque<String> queue = new LinkedList<>();
        int ind = 1;
        String dir;
        while (ind < path.length() && ind > 0) {
            int nextSlash = path.indexOf('/', ind);
            if (nextSlash == ind) {
                ind++;
                continue;
            } else if (nextSlash == -1) {
                dir = path.substring(ind);
            } else {
                dir = path.substring(ind, nextSlash);
            }
            if ("..".equals(dir)) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else if (!".".equals(dir)) {
                queue.offerLast(dir);
            }
            ind = nextSlash + 1;
        }
        if (queue.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append('/').append(queue.pollFirst());
        }
        return sb.toString();
    }
}
