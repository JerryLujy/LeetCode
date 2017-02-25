/**
 * <h1>329. Longest Increasing Path in a Matrix</h1>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1: nums =
 * <pre>
 * [[9,9,4],
 * [6,6,8],
 * [2,1,1]]
 * </pre>
 * Return 4. The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2: nums =
 * <pre>
 * [[3,4,5],
 * [3,2,6],
 * [2,2,1]]
 * </pre>
 * Return 4. The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * @author Jerry
 * @since 2/25/17
 */
public class LongestIncreasingPathInAMatrix {
    private static int[] delta = new int[]{0, 1, 0, -1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, mem));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int m = matrix.length, n = matrix[0].length;
        for (int k = 0; k < 4; k++) {
            int ii = i + delta[k], jj = j + delta[k + 1];
            if (ii >= 0 && ii < m && jj >= 0 && jj < n && matrix[ii][jj] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, ii, jj, mem));
            }
        }
        return ++mem[i][j];
    }
}
