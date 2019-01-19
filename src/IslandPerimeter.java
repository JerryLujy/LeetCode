/**
 * <h1>463. Island Perimeter</h1>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * Example: Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Output: 16
 *
 * @author Jerry
 * @since 1/19/19
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count += 4;
                if (i > 0 && grid[i - 1][j] == 1) {
                    count--;
                }
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    count--;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    count--;
                }
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    count--;
                }
            }
        }
        return count;
    }
}
