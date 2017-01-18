import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>118. Pascal's Triangle</h1>
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5, Return
 * <pre>
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * </pre>
 *
 * @author Jerry
 * @since 1/18/17
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        ans.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ans.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < last.size(); j++) {
                curr.add(last.get(j - 1) + last.get(j));
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }
}
