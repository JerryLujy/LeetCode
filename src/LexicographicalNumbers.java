import java.util.ArrayList;
import java.util.List;

/**
 * <h1>386. Lexicographical Numbers</h1>
 * Given an integer n, return 1 - n in lexicographical order. For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * <p>
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * @author Jerry
 * @since 2/8/17
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= Math.min(9, n); i++) {
            ans.add(i);
            generate(ans, i * 10, n);
        }
        return ans;
    }

    private void generate(List<Integer> ans, int cur, int n) {
        for (int i = cur; i <= Math.min(cur + 9, n); i++) {
            ans.add(i);
            generate(ans, i * 10, n);
        }
    }
}
