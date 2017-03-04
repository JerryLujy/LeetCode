/**
 * <h1>361. Bomb Enemy</h1>
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * <p>
 * Example: For the given grid, return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * <pre>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * </pre>
 *
 * @author Jerry
 * @since 3/3/17
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int rowKill = 0;
        int[] colKill = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    // Need to recalculate how many enemies can kill in this row
                    rowKill = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowKill++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    // Need to recalculate how many enemies can kill in this column
                    colKill[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colKill[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, rowKill + colKill[j]);
                }
            }
        }
        return ans;
    }
}
