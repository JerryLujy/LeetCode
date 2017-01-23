import java.util.HashMap;
import java.util.Map;

/**
 * <h1>149. Max Points on a Line</h1>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * @author Jerry
 * @since 1/22/17
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int ans = 0;
        Map<Double, Integer> counts = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int overlaps = 1;
            counts.clear();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                if (dx == 0 && dy == 0) {
                    ans = Math.max(ans, ++overlaps);
                    continue;
                }
                double slope = dx == 0 ? Double.POSITIVE_INFINITY :
                        dy == 0 ? 0 : ((double) dy / (double) dx);
                counts.merge(slope, 1, Integer::sum);
            }
            for (Integer count : counts.values()) {
                ans = Math.max(ans, count + overlaps);
            }
        }
        return ans;
    }

    private static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
