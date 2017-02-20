import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>317. Shortest Distance from All Buildings</h1>
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * <pre>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * </pre>
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *
 * @author Jerry
 * @since 2/19/17
 */
public class ShortestDistanceFromAllBuildings {
    private static int[] delta = new int[]{0, 1, 0, -1, 0};
    private static int m, n;

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        int[][] visits = new int[m][n];
        int[][] sumDistance = new int[m][n];
        int buildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    dfs(grid, i, j, visits, sumDistance);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visits[i][j] == buildings) {
                    ans = Math.min(ans, sumDistance[i][j]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[][] grid, int i, int j, int[][] visits, int[][] sumDistance) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        int dist = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int k = 0; k < count; k++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                sumDistance[x][y] += dist;
                visits[x][y]++;
                for (int d = 0; d < 4; d++) {
                    int xx = x + delta[d], yy = y + delta[d + 1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 0 && !visited[xx][yy]) {
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            dist++;
        }
    }
}
