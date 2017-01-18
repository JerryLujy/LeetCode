import java.util.List;

/**
 * <h1>120. Triangle</h1>
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <pre>
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * </pre>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 *
 * @author Jerry
 * @since 1/18/17
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            dp[i] = dp[i - 1] + row.get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
            }
            dp[0] += row.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = Math.min(min, i);
        }
        return min;
    }
}
