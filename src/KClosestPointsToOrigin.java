import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>973. K Closest Points to Origin</h1>
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * Example 1: Input: points = [[1,3],[-2,2]], K = 1. Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * Example 2: Input: points = [[3,3],[5,-1],[-2,4]], K = 2. Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author Jerry
 * @since 2/5/19
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> -(a[0] * a[0] + a[1] * a[1])));
        for (int[] point : points) {
            q.offer(point);
            if (q.size() > K) {
                q.poll();
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }
}
