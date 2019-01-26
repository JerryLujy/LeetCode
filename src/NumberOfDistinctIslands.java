import java.util.HashSet;
import java.util.Set;

/**
 * <h1>694. Number of Distinct Islands</h1>
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and only if
 * one island can be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * <p>
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * <p>
 * Notice that:
 * 11        1
 * 1   and  11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 * @author Jerry
 * @since 1/25/19
 */
public class NumberOfDistinctIslands {
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Set<Set<Integer>> islands = new HashSet<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1) {
                    Set<Integer> shape = new HashSet<>();
                    dfs(grid, shape, x, y, x, y);
                    islands.add(shape);
                }
            }
        }
        return islands.size();
    }

    private void dfs(int[][] grid, Set<Integer> shape, int sx, int sy, int x, int y) {
        grid[x][y] = 0;
        int m = grid.length, n = grid[0].length;
        shape.add((x - sx) * 2 * n + y - sy);
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 1) {
                dfs(grid, shape, sx, sy, xx, yy);
            }
        }
    }
}
