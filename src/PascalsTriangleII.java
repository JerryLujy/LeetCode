import java.util.ArrayList;
import java.util.List;

/**
 * <h1>119. Pascal's Triangle II</h1>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3, Return [1,3,3,1].
 * <p>
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author Jerry
 * @since 1/18/17
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            ans.add(1);
            for (int ind = row - 1; ind > 0; ind--) {
                ans.set(ind, ans.get(ind) + ans.get(ind - 1));
            }
        }
        return ans;
    }
}
