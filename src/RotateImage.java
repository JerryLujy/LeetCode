/**
 * <h1>48. Rotate Image</h1>
 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 *
 * @author Jerry
 * @since 8/26/16
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
