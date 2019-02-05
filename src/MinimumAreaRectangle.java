import java.util.HashSet;
import java.util.Set;

/**
 * <h1>939. Minimum Area Rectangle</h1>
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 * If there isn't any rectangle, return 0.
 * <p>
 * Example 1: Input: [[1,1],[1,3],[3,1],[3,3],[2,2]], Output: 4
 * <p>
 * Example 2: Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]], Output: 2
 * <p>
 * Note:
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 *
 * @author Jerry
 * @since 2/4/19
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] * 40001 + point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], x2 = points[j][0], y1 = points[i][1], y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && set.contains(x1 * 40001 + y2) && set.contains(x2 * 40001 + y1)) {
                    ans = Math.min(ans, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }
}
