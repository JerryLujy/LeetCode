import java.util.HashSet;
import java.util.Set;

/**
 * <h1>391. Perfect Rectangle</h1>
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * <p>
 * Each rectangle is represented as a bottom-left point and a top-right point.
 * For example, a unit square is represented as [1,1,2,2].(coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 * <p>
 * Example 1: Return true. All 5 rectangles together form an exact cover of a rectangular region.
 * <pre>
 * [[1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]]
 * </pre>
 * <image src="https://leetcode.com/static/images/problemset/rectangle_perfect.gif"/>
 * <p>
 * Example 2: Return false. Because there is a gap between the two rectangular regions.
 * <pre>
 * [[1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]]
 * </pre>
 * <image src="https://leetcode.com/static/images/problemset/rectangle_separated.gif"/>
 * <p>
 * Example 3: Return false. Because there is a gap in the top center.
 * <pre>
 * [[1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]]
 * </pre>
 * <image src="https://leetcode.com/static/images/problemset/rectangle_hole.gif"/>
 * <p>
 * Example 4: Return false. Because two of the rectangles overlap with each other.
 * <pre>
 * [[1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]]
 * </pre>
 * <image src="https://leetcode.com/static/images/problemset/rectangle_intersect.gif"/>
 *
 * @author Jerry
 * @since 3/8/17
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        Set<String> vertices = new HashSet<>();
        for (int[] rect : rectangles) {
            minX = Math.min(minX, rect[0]);
            minY = Math.min(minY, rect[1]);
            maxX = Math.max(maxX, rect[2]);
            maxY = Math.max(maxY, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String[] vertexStrs = new String[]{rect[0] + "-" + rect[1], rect[2] + "-" + rect[1],
                    rect[0] + "-" + rect[3], rect[2] + "-" + rect[3]};
            for (String vertex : vertexStrs) {
                if (vertices.contains(vertex)) {
                    vertices.remove(vertex);
                } else {
                    vertices.add(vertex);
                }
            }
        }
        String bl = minX + "-" + minY, br = maxX + "-" + minY, tl = minX + "-" + maxY, tr = maxX + "-" + maxY;
        return area == (maxX - minX) * (maxY - minY) && vertices.size() == 4 &&
                vertices.contains(bl) && vertices.contains(br) && vertices.contains(tl) && vertices.contains(tr);
    }
}
