/**
 * <h1>74. Search a 2D Matrix</h1>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * For example,Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * @author Jerry
 * @since 8/31/16
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rfrom = 0;
        int rto = matrix.length - 1;
        while (rfrom <= rto) {
            int mid = rfrom + (rto - rfrom) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                rto = mid - 1;
            } else {
                rfrom = mid + 1;
            }
        }
        //Should search target in the rto row
        if (rto < 0) {
            return false;
        }
        int[] row = matrix[rto];
        int cfrom = 0;
        int cto = matrix[0].length - 1;
        while (cfrom <= cto) {
            int mid = cfrom + (cto - cfrom) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                cto = mid - 1;
            } else {
                cfrom = mid + 1;
            }
        }
        return false;
    }
}
