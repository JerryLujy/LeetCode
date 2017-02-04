import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h1>247. Strobogrammatic Number II</h1>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * For example, Given n = 2, return ["11","69","88","96"].
 *
 * @author Jerry
 * @since 2/3/17
 */
public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }

    private List<String> findStrobogrammatic(int n, int m) {
        if (n == 0) {
            return Collections.singletonList("");
        } else if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> ans = new ArrayList<>();
        for (String s : findStrobogrammatic(n - 2, m)) {
            if (n != m) {
                ans.add("0" + s + "0");
            }
            ans.add("1" + s + "1");
            ans.add("8" + s + "8");
            ans.add("6" + s + "9");
            ans.add("9" + s + "6");
        }
        return ans;
    }
}
