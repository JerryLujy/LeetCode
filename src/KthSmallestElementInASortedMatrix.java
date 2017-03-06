import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>378. Kth Smallest Element in a Sorted Matrix</h1>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example: matrix =
 * <pre>
 * [[ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]],
 * </pre>
 * k = 8, return 13.
 *
 * @author Jerry
 * @since 3/6/17
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> matrix[e[0]][e[1]]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i});
        }
        while (--k > 0) {
            int[] cur = pq.poll();
            if (cur[0] + 1 < m) {
                pq.offer(new int[]{cur[0] + 1, cur[1]});
            }
        }
        int[] cur = pq.poll();
        return matrix[cur[0]][cur[1]];
    }
}
