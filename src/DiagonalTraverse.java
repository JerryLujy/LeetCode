/**
 * <h1>498. Diagonal Traverse</h1>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * @author Jerry
 * @since 1/20/19
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length, r = 0, c = 0, ind = 0;
        int[] ans = new int[m * n];
        while (r < m && c < n) {
            ans[ind++] = matrix[r][c];
            if ((r + c) % 2 == 0) { // Up
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--; c++;
                }
            } else { // Down
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++; c--;
                }
            }
        }
        return ans;
    }
}
