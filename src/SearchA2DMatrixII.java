/**
 * <h1>240. Search a 2D Matrix II</h1>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * For example, Consider the following matrix:
 * <pre>
 * [
 * [ 1,  4,  7, 11, 15],
 * [ 2,  5,  8, 12, 19],
 * [ 3,  6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * </pre>
 * Given target = 5, return true. Given target = 20, return false.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
