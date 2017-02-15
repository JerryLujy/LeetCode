/**
 * <h1>304. Range Sum Query 2D - Immutable</h1>
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8,
 * sumRegion(1, 1, 2, 2) -> 11,
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * Note:
 * You may assume that the matrix does not change. There are many calls to sumRegion function.
 * You may assume that row1 <= row2 and col1 ≤ col2.
 *
 * @author Jerry
 * @since 2/14/17
 */
public class RangeSumQuery2DImmutable {
    private int[][] mem;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        mem = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i + 1][j + 1] = mem[i][j + 1] + mem[i + 1][j] - mem[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mem[row2 + 1][col2 + 1] - mem[row2 + 1][col1] - mem[row1][col2 + 1] + mem[row1][col1];
    }
}
