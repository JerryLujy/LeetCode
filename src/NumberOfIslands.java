/**
 * <h1>200. Number of Islands</h1>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <pre>
 * 11110
 * 11010
 * 11000
 * 00000
 * </pre>
 * Answer: 1
 * <p>
 * Example 2:
 * <pre>
 * 11000
 * 11000
 * 00100
 * 00011
 * </pre>
 * Answer: 3
 *
 * @author Jerry
 * @since 1/27/17
 */
public class NumberOfIslands {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    markLand(grid, i, j, m, n);
                }
            }
        }
        return ans;
    }

    private void markLand(char[][] grid, int x, int y, int m, int n) {
        grid[x][y] = 'M';
        for (int ind = 0; ind < 4; ind++) {
            int i = x + dx[ind], j = y + dy[ind];
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
                markLand(grid, i, j, m, n);
            }
        }
    }
}
