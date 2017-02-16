/**
 * <h1>311. Sparse Matrix Multiplication</h1>
 * Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 *
 * @author Jerry
 * @since 2/16/17
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 ||
                B == null || B.length == 0 || B[0].length == 0) {
            return null;
        }
        int[][] ans = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] == 0) {
                    continue;
                }
                for (int j = 0; j < B[0].length; j++) {
                    if (B[k][j] == 0) {
                        continue;
                    }
                    ans[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return ans;
    }
}
