/**
 * <h1>59. Spiral Matrix II</h1>
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * <p>
 * For example, Given n = 3, You should return the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * <p>
 * [ 8, 9, 4 ],
 * <p>
 * [ 7, 6, 5 ]
 * ]
 *
 * @author Jerry
 * @since 8/28/16
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cur = 1;
        int rowfrom = 0;
        int rowto = n - 1;
        int colfrom = 0;
        int colto = n - 1;
        while (rowfrom <= rowto && colfrom <= colto) {
            for (int i = colfrom; i <= colto; i++) ans[rowfrom][i] = cur++;
            rowfrom++;
            for (int i = rowfrom; i <= rowto; i++) ans[i][colto] = cur++;
            colto--;
            for (int i = colto; i >= colfrom; i--) ans[rowto][i] = cur++;
            rowto--;
            for (int i = rowto; i >= rowfrom; i--) ans[i][colfrom] = cur++;
            colfrom++;
        }
        return ans;
    }
}
