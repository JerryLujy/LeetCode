import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>286. Walls and Gates</h1>
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * For example, given the 2D grid:
 * <pre>
 * INF -1   0  INF
 * INF INF INF  -1
 * INF -1  INF  -1
 *  0  -1  INF INF
 * </pre>
 * After running your function, the 2D grid should be:
 * <pre>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * </pre>
 *
 * @author Jerry
 * @since 2/11/17
 */
public class WallsAndGates {
    private static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] direction : directions) {
                int i = curr[0] + direction[0], j = curr[1] + direction[1];
                if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[i][j] = rooms[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{i, j});
            }
        }
    }
}
